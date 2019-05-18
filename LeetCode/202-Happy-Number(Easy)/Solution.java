class Solution {
    private int sumOfSquares(int n) {
        int sum = 0;
        
        while (n > 0) {
            int temp = n%10;
            
            sum += temp*temp;
            
            n /= 10;
        }
        
        return sum;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        
        while (!visited.contains(n)) {
            if (n == 1) return true;
            visited.add(n);
            
            n = sumOfSquares(n);
        }
        
        return false;
    }
}