/**
 * Manacher
 */
class Solution3 {
     public String longestPalindrome(String s) {
        
        if (s==null || s.length() == 0) return "";
        
        int extendedLen = s.length()*2 + 1;
        char[] charArr = new char[extendedLen];
        
        int idx = 0;
        for (char ch : s.toCharArray()) {
            charArr[idx++] = '#';
            charArr[idx++] = ch;
        }
        charArr[idx] = '#';
        
        int[] p = new int[extendedLen];
        int center=0, maxLen = 0;
        int pivot=0, maxPos=0;
        
        p[0] = 1;
        for (int i=1; i < extendedLen; i++) {
            
            // this is key point to reach real O(n) time complex
            p[i] = (maxPos > i)? Math.min(p[2*pivot - i], maxPos - i):1 ;
            
            while (i + p[i] < extendedLen && i - p[i] >= 0 && charArr[i + p[i]] == charArr[i - p[i]]) {
                ++p[i];
            }
            if (i + p[i] > maxPos) {
                maxPos = i + p[i];
                pivot = i;
            }
            if (p[i] > maxLen) {
                maxLen = p[i];
                center = i;
            }
        }
        
        return s.substring( (center - maxLen + 1)/2 , (center + maxLen - 1)/2);
    }
}