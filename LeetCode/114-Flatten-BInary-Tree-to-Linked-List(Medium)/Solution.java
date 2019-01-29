/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Use preorder traversal
 * 
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        
        TreeNode dummy = new TreeNode(0);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            dummy.right = node;
            dummy.left = null;
            
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            
            dummy = node;
        }
    }
}