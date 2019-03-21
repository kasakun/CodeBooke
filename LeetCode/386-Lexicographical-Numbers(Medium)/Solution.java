class Solution {
    private void lexicalOrderHelper(int n, List<Integer> res, int num) {
        res.add(num);
        
        for (int i = 0; i < 10; ++i) {
            if ((num*10 + i) > n) continue;
            
            lexicalOrderHelper(n, res, num*10 + i);
        }
        return;
    }
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 1; i <= 9 && i <= n; ++i) {
            lexicalOrderHelper(n, res, i);
        }
        
        return res;
    }
}