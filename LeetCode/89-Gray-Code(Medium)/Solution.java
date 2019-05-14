class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();res.add(0);
        if (n <= 0) return res;
        
        res.add(1);
        int base1 = 3, base2 = 1;
        
        for (int i = 1; i < n; ++i) {
            int count = res.size();
            
            for (int j = 0; j < count/2; ++j)
                res.add(base1 + res.get(j));
            
            for (int j = count/2; j < count; ++j)
                res.add(base2 + res.get(j));
            
            base1 *= 2; base2 *= 2;
        }
        
        return res;
    }
}