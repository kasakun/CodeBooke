/**
 * First, clear all spaces using trim()
 * 
 * Loop:
 * isCharDigit?_______ Yes append
 *        |
 *        |___ No_____ isFoundDigit?____ Yes break
 *                           |
 *                           |__ No_____ isSigned?___ Yes not valid
 *                                            |
 *                                            |____ isASign? ____ Yes mark and continue
 *                                                      |
 *                                                      |_____ No not valid                                
 *                                              
 */
class Solution {
    private boolean isSign(char c) {
        return c == '-' || c == '+';    
    }
    
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        str = str.trim();
        
        
        char[] charArr = str.toCharArray();
        char sign = '+';
        boolean isSigned = false;
        boolean isFoundDigit = false;
        StringBuilder sb = new StringBuilder();
        
        for (char c : charArr) {
            if (!Character.isDigit(c) && isFoundDigit)
                break;
            if (!Character.isDigit(c) && !isFoundDigit) {
                if (isSign(c) && !isSigned) {
                    isSigned = true;
                    sign = c;
                    continue;
                }
                return 0;
            }
            sb.append(c);
            isFoundDigit = true;
            
            long val = new Long(sb.toString()).longValue();
            if (val > Integer.MAX_VALUE) 
                break;
        }
        
        if (sb.length() == 0) 
            return 0;
        
        long val = new Long(sb.toString()).longValue();
        
        if (val > Integer.MAX_VALUE && sign == '+') 
            return Integer.MAX_VALUE;
        else if (val > Integer.MAX_VALUE && sign == '-') 
            return Integer.MIN_VALUE;
        else if (sign == '+') 
            return (int) val;
        else if (sign == '-') 
            return 0 - (int) val;
        return 0;
    }
}