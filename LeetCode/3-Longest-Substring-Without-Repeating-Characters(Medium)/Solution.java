/**
 * Take the example: "abcdefghijkgmln"
 * 
 * We use two pointers: start and end.
 * The start always indicates the start of the no-duplicate-substring
 * The end always indicates the end of the no-duplicate-substring
 * 
 * For one iteration, the steps can be:
 * 1. End keeps going until we find a duplicate.
 * 2. Record the length and update the max.
 * 3. Start starts moving until skip the first char. (start will keep going to 'h')
 *    Meanwhile, cleer the count while start is inreasing.
 * 
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        int[] count = new int[128];
        
        while (end < s.length()) {
            char c = s.charAt(end);
            ++count[c];
            
            if (count[c] > 1) {
                //duplicate happens
                max = Math.max(max, end - start);
                
                while(count[s.charAt(start)]<2){
                    // Keep going to the one after
                    // the first.
                    count[s.charAt(start)]--;
                    start++;
                }
                
                count[s.charAt(start)]--;
                start++;
            }
            ++end;
        }
        
        max = Math.max(max,end-start);
        
        return max;
    }
}