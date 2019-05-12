class Solution {
    private boolean match(int[] dict1, int[] dict2) {
        for (int i = 0; i < 26; ++i)
            if (dict1[i] != dict2[i]) return false;
        
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] dict1 = new int[26], dict2 = new int[26];
        
        // window size = s1.length()
        for (int i = 0; i < s1.length(); ++i) {
            ++dict1[s1.charAt(i) - 'a'];
            ++dict2[s2.charAt(i) - 'a'];
        }
        
        for (int i = 0; i < s2.length() - s1.length(); ++i) {
            if (match(dict1, dict2)) return true;
            
            ++dict2[s2.charAt(i + s1.length()) - 'a'];
            --dict2[s2.charAt(i) - 'a'];
        }
        
        return match(dict1, dict2);
    }
}