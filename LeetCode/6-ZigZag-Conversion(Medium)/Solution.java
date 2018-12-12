/**
 * Create a numRows buffer and then convert it to a string.
 */
class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        char[] charArr = s.toCharArray();
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < numRows; ++i)
            sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < numRows && i < len; ++idx)
                sb[idx].append(charArr[i++]);
            for (int idx = numRows - 2; idx >= 1 && i < len; --idx)
                sb[idx].append(charArr[i++]);
        }
        
        for (int idx = 1; idx < numRows; ++idx)
            sb[0].append(sb[idx]);
        
        return sb[0].toString();
    }
}