class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        
        int indexS = 0, indexT = 0;
        
        for (;indexT < t.length(); ++indexT) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                ++indexS;
                if (indexS == s.length()) return true;
            }
        }
        
        return false;
    }
}