/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBSTHelper(TreeNode node, long lower, long upper) {
        if (node == null)
            return true;
        
        if (node.val <= lower || node.val >= upper)
            return false;
        
        return isValidBSTHelper(node.left, lower, node.val) &&
               isValidBSTHelper(node.right, node.val, upper);
    }
}