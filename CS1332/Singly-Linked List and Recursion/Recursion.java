/**
 * Your implementation of Recursion
 *
 * @author Zeyu Chen
 * @version 1.0
 */
public class Recursion {
    // DO NOT ADD ANY ADDITIONAL INSTANCE VARIABLES

    /**
     * Returns a boolean value representing whether the passed in character
     * sequence is a valid palindrome. A palindrome is defined as such:
     * A word, phrase, or sequence that reads the same backward as forward.
     *
     * Palindromes are recursively defined as such:
     * Case 1: An empty string or single character is considered a palindrome
     * Case 2: A string is a palidrome if and only if the first and last
     * characters are the same and the substring between the first and last
     * characters is itself a palindrome (recursively check if the substring
     * is a palindrome).
     *
     * This method must be computed recursively! Failure to do so will result
     * in zero credit for this method. You must use a private helper method
     * for the recursion.
     *
     * @param text The sequence that will be tested to see if it is a palindrome
     * @return Whether the passed in word is a palindrome
     * @throws IllegalArgumentException if text is null
     */
    public boolean isPalindrome(String text) {
    }

    /**
     * Recursive helper function for isPalindrome
     * @param text input sequence to test if it is a palindrome
     * @return If the passed in text is a palindrome
     */
    private boolean isPalindromeHelper(String text) {
    }

    /**
     * Returns the greatest common divisor of integers x and y. The greatest
     * common divisor can be determined by the recursive function as follows:
     *
     * Case 1: gcd(x, y) = gcd(x-y, y) where x > y
     * Case 2: gcd(x, y) = gcd(x, y-x) where x < y
     * Case 3: gcd(x, y) = x = y where x == y
     * Case 4 (Edge case): gcd(x, y) = {x if y == 0 or y if x == 0}
     *
     * This method must be computed recursively! Failure to do so will result
     * in zero credit for this method. You must use a private helper method 
     * for the recursion.
     *
     * @param x The first integer
     * @param y The second integer
     * @return The greatest common divisor of x and y, or -1 if either
     * x or y is negative
     */
    public int gcd(int x, int y) {
        
    }

    /**
     * Recursive helper function call for gcd
     * @param x The first integer
     * @param y The second integer
     * @return the gcd of x and y, or -1 if either are negative
     */
    private int gcdHelper(int x, int y) {
    }
}
