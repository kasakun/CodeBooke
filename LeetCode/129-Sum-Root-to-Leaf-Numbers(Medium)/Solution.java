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
    private int sum = 0;
    
    private void sumNumbersHelper(TreeNode node, int pathValue) {
        if (node.left == null && node.right == null) {
            sum += pathValue*10 + node.val;
            return;
        }
        
        if (node.left != null) sumNumbersHelper(node.left, pathValue*10 + node.val);
        if (node.right != null) sumNumbersHelper(node.right, pathValue*10 + node.val);
    }
    public int sumNumbers(TreeNode root) {
        if (root == null) return sum;
        
        sumNumbersHelper(root, 0);
        
        return sum;
    }
}