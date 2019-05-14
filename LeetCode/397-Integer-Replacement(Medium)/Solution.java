/**
 * Up to down.
 * I tried down to up, fail in memeory limitation.
 * So keep simple!
 */
class Solution {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) return integerReplacement(n-1);
        if (n == 1) return 0;
        if (n%2 == 0) return integerReplacement(n/2)+1;  
        return Math.min(integerReplacement(n-1), integerReplacement(n+1))+1;
    }
}