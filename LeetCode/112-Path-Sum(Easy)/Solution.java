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
    private int curr = 0;
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        return hasPathSumHelper(root, sum);
    }
    
    private boolean hasPathSumHelper(TreeNode node, int sum) {
        if (node.left == null && node.right == null)
            return (curr + node.val) == sum;
        boolean left = false, right = false;
        
        curr += node.val;
        if (node.left != null)
            left = hasPathSumHelper(node.left, sum);
        if (node.right != null)
            right = hasPathSumHelper(node.right, sum);
        curr -= node.val;
        
        return left || right;
    }
}