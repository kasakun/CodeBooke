class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] strs = preorder.split(",");
        
        /**diff = indegree - outdegree
         */
        int diff = 0;
        
        for (int i = 0; i < strs.length; ++i) {
            if (i != 0) ++diff; // root does not have indegree
            
            // plz draw it via pre order under this rule, you can only find arrow heads pointing out(diff < 0)
            if (diff > 0) return false;
            
            if (!strs[i].equals("#")) diff -= 2; // non-leaf have 2 outdegrees
            
        }
        
        return diff == 0;
    }
}