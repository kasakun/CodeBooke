class Solution {
    public List<Integer> getRow(int rowIndex) {
        // < 0 leetcode judge outputs [1]
        List<Integer> res = new ArrayList<>();res.add(1);
        if (rowIndex < 0) return res;
        List<Integer> pre = res;
        
        for (int row = 1; row <= rowIndex; ++row) {
            res = new ArrayList();
            res.add(1);
            
            for (int i = 0; i < row - 1; ++i)
                res.add(pre.get(i) + pre.get(i + 1));
            
            res.add(1);
            
            pre = res;
        }
        
        return res;
    }
}