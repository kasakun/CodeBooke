/**
 * Greedy
 * 
 * When a digit is removed, it means the digit after that is replacing that one.
 * Thus, we only need to determine which is larger? num[i] and num[i + 1]
 * 
 * Take 234723 as example,
 * 
 * Push element into stack one by one.
 * When it comes to 23, 23* is smaller than 24*, so we keep 23 and push 4 into stack
 * Otherwise, when it comes to 2347, 2347* is larger than 2342*, so we replace it.
 * 
 * After scanning, k might be > 0. Then we remove the tail one by one until k == 0.
 *
 * Also see as Monotonous Increase Stack.
 */
class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) return "0";
        
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        
        for (int i = 0; i < num.length(); ++i) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
                stack.pop();
                --k;
            }
            
            stack.push(num.charAt(i));
        }
        
        while(k > 0) {
            stack.pop();
            --k;
        }
        
        while (!stack.isEmpty())
            res.append(stack.pop());
        
        res.reverse();
        
        while (res.length() > 1 && res.charAt(0) == '0')  {
            res.deleteCharAt(0);
        }
        
        return res.toString();
    }
}