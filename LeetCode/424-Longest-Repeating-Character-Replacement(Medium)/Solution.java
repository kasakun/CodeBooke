/**
 * Sliding window. Link to 1004
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, max = 0, numOfMaxRepeat = 0;
        int[] dict = new int[26];
        
        for (; right < s.length(); ++right) {
            numOfMaxRepeat = Math.max(numOfMaxRepeat, ++dict[s.charAt(right) - 'A']);
            
            int numOfReplace = right - left + 1 - numOfMaxRepeat;
            
            if (numOfReplace > k) {
                --dict[s.charAt(left) - 'A'];
                ++left;
            } else {
                max = Math.max(max, right - left + 1);
            }
        }
        
        return max;
    }
}