/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * If an object is null and it is parsed into a func, it will be pass by value.
 */
class Solution2 {
    TreeNode prev = null;

    private boolean isValid(TreeNode node) {
        if (node == null) return true;
        
        if (!isValid(node.left)) return false;
        
        if (prev != null && prev.val >= node.val) return false;

        prev = node;
        
        return isValid(node.right);
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }
}