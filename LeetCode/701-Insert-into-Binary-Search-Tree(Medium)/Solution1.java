/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Recursion
 */
class Solution1 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        
        if (val > root.val)
            root.right = insertIntoBST(root.right, val);
        else
            root.left = insertIntoBST(root.left, val);
        
        return root;
    }
}