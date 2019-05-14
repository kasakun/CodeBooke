/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Recursion
 */
class Solution1 {
    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        
        // i is root
        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftSubTrees = generateTreesHelper(start, i - 1);
            List<TreeNode> rightSubTrees = generateTreesHelper(i + 1, end);
            
            //construct all possible combinations
            for (TreeNode leftRoot: leftSubTrees) {
                for (TreeNode rightRoot: rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    res.add(root);
                }
            }
        }
        
        return res;
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return generateTreesHelper(1, n);
    }
}