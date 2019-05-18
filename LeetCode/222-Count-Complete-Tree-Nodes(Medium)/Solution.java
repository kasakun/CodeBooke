/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * The idea is simple.
 * If leftdepth and rightdepth are the same, we can use formula.
 * 
 * otherwise we recursively go through the children
 * 
 */
class Solution {
    private int leftDepth(TreeNode node) {
        int depth = 0;
        
        while (node != null) {
            node = node.left;
            ++depth;
        }
        
        return depth;
    }
    
    private int rightDepth(TreeNode node) {
        int depth = 0;
        
        while (node != null) {
            node = node.right;
            ++depth;
        }
        
        return depth;
    }
    
    public int countNodes(TreeNode root) {
        int left = leftDepth(root);
        int right = rightDepth(root);
        
        if (left == right)
            return (1 << left) - 1;
        else
            return 1 + countNodes(root.left) + countNodes(root.right);
    }
}