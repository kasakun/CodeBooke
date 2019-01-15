/**
 * The solution is tricky and not typical.
 * 
 * 1. The position of first num of kth permuataion in n-element set is (k-1)/(n-1)!
 * 2. Elimnate the used num, and do it again with the rest of the set.
 */
class Solution {
    public String getPermutation(int n, int k) {
        int [] factorial = new int[n];
        
        //create factorial
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            factorial[i] = factorial[i - 1]*i;
        }
        
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int i = 1; i <= n; ++i) {
            numbers.add(i);
        }
        
        // The kth index is of n elements (k-1)/(n-1)!
        String res = "";
        for (int i = n - 1; i >= 0; --i) {
            int index = (k - 1)/factorial[i];
            res += numbers.get(index);
            // change the k for the n-1 elements
            k -= index*factorial[i];
            numbers.remove(index);
        }
        
        return res;
    }
}