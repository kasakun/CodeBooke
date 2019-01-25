/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean res = true;
    
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = depth(root.left);
        int right = depth(root.right);
        
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        
        return 1 + Math.max(left, right);
    }
    
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return res;
    }
}