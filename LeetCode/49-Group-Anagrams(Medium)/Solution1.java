/** 
 * Intuitive
 *
 * BUT, TLE
 */
 class Solution {
    private boolean isAnagram(String str, int[] dict) {
        int[] newDict = new int[26];
        for (char ch : str.toCharArray()) ++newDict[ch - 'a'];
        
        for (int i = 0; i < 26; ++i)
            if (dict[i] != newDict[i])
                return false;
        return true;
    }

    private int[] constructDict(String str) {
        int[] dict = new int[26];
        
        for (char ch : str.toCharArray()) ++dict[ch - 'a'];
        
        return dict;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;

        Map<String, int[]> map = new HashMap<>();
        
        for (String str : strs) {
            int i = 0;
            for (; i < res.size(); ++i) {
                String string = res.get(i).get(0);
                if (isAnagram(str, map.get(string))) {res.get(i).add(str);break;}
                
            }
            
            if (i == res.size()) {
                // not found, build a new one
                List<String> temp = new ArrayList<>();
                temp.add(str);
                res.add(temp);
                map.put(str, constructDict(str));
            }
        }
        return res;
    }
}