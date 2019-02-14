class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        
        for (int row = 0; row < numRows; ++row) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            
            for (int i = 0; i < row - 1; ++i)
                list.add(res.get(row - 1).get(i) + res.get(row - 1).get(i + 1));
    
            if (row != 0) list.add(1);
            
            res.add(list);
        }
        
        return res;
    }
}