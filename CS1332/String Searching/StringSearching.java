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

    /**
     * Prime base used for Rabin-Karp hashing.
     * DO NOT EDIT!
     */
    private static final int BASE = 181;

    /**
     * Runs Rabin-Karp algorithm. Generate the pattern hash, and compare it with
     * the hash from a substring of text that's the same length as the pattern.
     * If the two hashes match, compare their individual characters, else update
     * the text hash and continue.
     *
     * @throws IllegalArgumentException if the pattern is null or of length 0
     * @throws IllegalArgumentException if text or comparator is null
     * @param pattern a string you're searching for in a body of text
     * @param text the body of text where you search for pattern
     * @param comparator the comparator to use when checking character equality
     * @return list containing the starting index for each match found
     */
    public static List<Integer> rabinKarp(CharSequence pattern,
                      CharSequence text, CharacterComparator comparator) {
        if (pattern  == null || pattern.length() == 0) {
            throw new IllegalArgumentException("Null or empty pattern cannot"
                    + " be used in string searching");
        }

        if (text == null || comparator == null) {
            throw new IllegalArgumentException("Null text or "
                    + "null comparator cannot be used in string searching");
        }

        List<Integer> result = new ArrayList<>();

        int patternHash = generateHash(pattern, pattern.length());
        int textHash = generateHash(text, pattern.length());

        int i = 0;
        while (i <= text.length() - pattern.length()) {
            if (patternHash == textHash) {

                int j = 0;
                while (j < pattern.length()
                        && comparator.compare(text.charAt(i + j),
                        pattern.charAt(j)) == 0) {
                    j++;
                }
                if (j == pattern.length()) {
                    result.add(i);
                }

            }

            int len = pattern.length();

            if (i + len < text.length()) {
                textHash = updateHash(textHash, len, text.charAt(i),
                        text.charAt(i + len));
            }
            ++i;
        }

        return result;
    }

    /**
     * Hash function used for Rabin-Karp. The formula for hashing a string is:
     *
     * sum of: c * BASE ^ (pattern.length - 1 - i), where c is the integer
     * value of the current character, and i is the index of the character
     *
     * For example: Hashing "bunn" as a substring of "bunny" with base 181 hash
     * = b * 181 ^ 3 + u * 181 ^ 2 + n * 181 ^ 1 + n * 181 ^ 0 = 98 * 181 ^ 3 +
     * 117 * 181 ^ 2 + 110 * 181 ^ 1 + 110 * 181 ^ 0 = 584967675
     *
     * Note that the largest possible value for an int is 2147483647, so it is
     * possible that the calculated hash may roll over.
     *
     *
     * Do NOT use {@code Math.pow()} in this method. We have provided a pow()
     * method for you to use.
     *
     * @throws IllegalArgumentException if current is null
     * @throws IllegalArgumentException if length is negative, 0, or greater
     *     than the length of current
     * @param current substring you are generating hash function for
     * @param length the length of the string you want to generate the hash for,
     * starting from index 0. For example, if length is 4 but current's length
     * is 6, then you include indices 0-3 in your hash (and pretend the actual
     * length is 4)
     * @return hash of the substring
     */
    public static int generateHash(CharSequence current, int length) {
        if (current == null) {
            throw new IllegalArgumentException("Cannot generate hash from"
                    + "null string");
        }

        if (length <= 0 || length > current.length()) {
            throw new IllegalArgumentException("Invalid length, length is"
                    + "less than or equal to zero or greater than the length"
                    + "of current string");
        }

        int hash = 0;
        for (int i = 0; i < length; i++) {
            hash += current.charAt(i) * pow(BASE, length - 1 - i);
        }
        return hash;
    }

    /**
     * Updates a hash in constant time to avoid constantly recalculating
     * entire hash. To update the hash:
     *
     *  remove the oldChar times BASE raised to the length - 1, multiply by
     *  BASE, and add the newChar.
     *
     * For example: Shifting from "bunn" to "unny" in "bunny" with base 181
     * hash("unny") = (hash("bunn") - b * 181 ^ 3) * 181 + y * 181 ^ 0 =
     * (584967675 - 98 * 181 ^ 3) * 181 + 121 * 181 ^ 0 = 697403438
     *
     *
     * The computation of BASE raised to length - 1 may require O(log n) time,
     * but the method should otherwise run in O(1).
     *
     * Do NOT use {@code Math.pow()} in this method. We have provided a pow()
     * method for you to use.
     *
     * @throws IllegalArgumentException if length is negative or 0
     * @param oldHash hash generated by generateHash
     * @param length length of pattern/substring of text
     * @param oldChar character we want to remove from hashed substring
     * @param newChar character we want to add to hashed substring
     * @return updated hash of this substring
     */
    public static int updateHash(int oldHash, int length, char oldChar,
                                 char newChar) {
        if (length <= 0) {
            throw  new IllegalArgumentException("length cannot be zero"
                    + "or negative");
        }

        int newHash;

        oldHash = oldHash - oldChar*pow(BASE, length - 1);
        oldHash = oldHash*BASE;
        newHash = oldHash + newChar;

        return newHash;
    }

    /**
     * Calculate the result of a number raised to a power.
     *
     * DO NOT MODIFY THIS METHOD.
     *
     * @throws IllegalArgumentException if both {@code base} and {@code exp} are
     * 0
     * @throws IllegalArgumentException if {@code exp} is negative
     * @param base base of the number
     * @param exp power to raise the base to. Must be 0 or greater.
     * @return result of the base raised to that power
     */
    private static int pow(int base, int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Exponent cannot be negative.");
        } else if (base == 0 && exp == 0) {
            throw new IllegalArgumentException(
                    "Both base and exponent cannot be 0.");
        } else if (exp == 0) {
            return 1;
        } else if (exp == 1) {
            return base;
        }
        int halfPow = pow(base, exp / 2);
        if (exp % 2 == 0) {
            return halfPow * halfPow;
        } else {
            return halfPow * pow(base, (exp / 2) + 1);
        }
    }
}