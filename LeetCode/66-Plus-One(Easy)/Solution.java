/**
 * 
 * The tricky point is if the number of the array changes, there
 * is only one possible: 10...0
 * 
 */
class Solution {
    public int[] plusOne(int[] digits) {
        int c = (digits[digits.length - 1] + 1)/10;
        digits[digits.length - 1] = (digits[digits.length - 1] + 1)%10;
        
        for (int i = digits.length - 2; i >= 0; --i) {
            int sum = (digits[i] + c)%10;
            c = (digits[i] + c)/10;
            
            digits[i] = sum;
        }
        
        if (c == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            return digits;
        }
    }
}