/**
 * Find the most frequent char_x.
 *
 * The interval sequence must be:
 *
 * char_x,.....,char_x,.....,char_x,.....
 *
 * Then we can put next most to the interval between char_x
 *
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] map = new int[26];
        
        for (char c : tasks) ++map[c - 'A'];
        
        Arrays.sort(map);
        
        while (map[25] > 0) {
            int i = 0;   
            // interval n
            while (i <= n && map[25] != 0) {
                
                //assign next most
                if(i < 26 && map[25 - i] > 0) --map[25 - i];
                
                ++time;
                ++i;
            }
            Arrays.sort(map);
        }
        
        return time;
    }
}