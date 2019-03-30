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
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    private void traverse(TreeNode node) {
        if (node == null) return;
        
        traverse(node.left);
        
        // first element must be the former one, while second must be the latter one
        if (first == null && prev.val > node.val)
            first = prev;
        
        // first is found before second
        if (first != null && prev.val > node.val)
            second = node;
        
        prev = node;
        
        traverse(node.right);
    }
    
    public void recoverTree(TreeNode root) {
        int temp;
        
        traverse(root);
        
        temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return;
    }
}