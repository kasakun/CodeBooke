import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Zeyu Chen
 * @version 0.1
 */
public class StringSearching {
    /**
     * @throws IllegalArgumentException if pattern is null or of length 0
     * @throws IllegalArgumentException if text or comparator is null
     * @param pattern the pattern you are searching for in a body of text
     * @param text the body of text where you search for pattern
     * @param comparator the comparator to use when checking character equality
     * @return list containing the starting index for each match found
     */
    public static List<Integer> kmp(CharSequence pattern, CharSequence text,
                                    CharacterComparator comparator) {
        
        if (pattern  == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Null or empty pattern!");
        }
        if (text == null || comparator == null) {
            throw new IllegalArgumentException("Null text or null comparator!");
        }

        List<Integer> result = new ArrayList<>();
        if (text.length() == 0 || text.length() < pattern.length()) {
            return result;
        }

        int i = 0, j = 0;
        int[] failureTable = buildFailureTable(pattern, comparator);

        while (i <= text.length() - pattern.length()) {
            while (j < pattern.length() && 
                       comparator.compare(text.charAt(i + j), 
                                          pattern.charAt(j)) == 0)
                ++j;

            if (j == 0)
                i++;
            else {
                if (j == pattern.length())
                    result.add(i);

                int next = failureTable[j - 1];
                i = i + j - next;
                j = next;
            }
        }

        return result;
    }

    /**
     * Builds failure table that will be used to run the Knuth-Morris-Pratt
     * (KMP) algorithm.
     *
     * The table built should be the length of the input text.
     *
     * If the pattern is empty, return an empty array.
     *
     * @throws IllegalArgumentException if the pattern or comparator is null
     * @param pattern a {@code CharSequence} you're building a failure table for
     * @param comparator the comparator to use when checking character equality
     * @return integer array holding your failure table
     */
    public static int[] buildFailureTable(CharSequence pattern,
                                          CharacterComparator comparator) {
        if (pattern == null || comparator == null) {
            throw new IllegalArgumentException("Null pattern or null comparator!");
        }

        int[] table = new int[pattern.length()];
        int i = 0;
        for (int j = 1; j < pattern.length();) {
            if (comparator.compare(pattern.charAt(i), pattern.charAt(j)) == 0) {
                table[j] = i + 1;
                ++i;
                ++j;
            } else {
                if (i == 0) {
                    table[j] = 0;
                    ++j;
                } else 
                    i = table[i - 1];
            }
        }

        return table;
    }

    /**
     * Boyer Moore algorithm that relies on last occurrence table. Works better
     * with large alphabets.
     *
     * Make sure to implement the last occurrence table before implementing this
     * method.
     *
     * @throws IllegalArgumentException if the pattern is null or of length 0
     * @throws IllegalArgumentException if text or comparator is null
     * @param pattern the pattern you are searching for in a body of text
     * @param text the body of text where you search for the pattern
     * @param comparator the comparator to use when checking character equality
     * @return list containing the starting index for each match found
     */
    public static List<Integer> boyerMoore(CharSequence pattern,
                                           CharSequence text, 
                                           CharacterComparator comparator) {

        if (pattern  == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Null or empty pattern!");
        }

        if (text == null || comparator == null) {
            throw new IllegalArgumentException("Null text or null comparator!");
        }

        List<Integer> result = new ArrayList<>();

        Map<Character, Integer> lastTable = buildLastTable(pattern);

        int i = 0;

        while (i <= text.length() - pattern.length()) {
            // start from last character
            int j = pattern.length() - 1;
            while (j >= 0 && comparator.compare(text.charAt(i + j),
                                                pattern.charAt(j)) == 0) {
                --j;
            }
            if (j == -1) {
                result.add(i);
                ++i;
            } else {
                // because we have match the good last
                int shiftedIndex = lastTable.getOrDefault(text.charAt(i + j), -1);
                if (shiftedIndex < j)
                    i += j - shiftedIndex;
                else
                    ++i;
            }
        }

        return result;
    }

    /**
     * Builds last occurrence table that will be used to run the Boyer Moore
     * algorithm.
     *
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     *
     * Ex. octocat
     *
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     *
     * If the pattern is empty, return an empty map.
     *
     * @throws IllegalArgumentException if the pattern is null
     * @param pattern a {@code CharSequence} you are building last table for
     * @return a Map with keys of all of the characters in the pattern mapping
     *         to their last occurrence in the pattern
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("null pattern");
        }

        Map<Character, Integer> lastTable = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            lastTable.put(pattern.charAt(i), i);
        }
        return lastTable;
    }
}