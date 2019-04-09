/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 *
 * Recursion:
 * There is three situations when a node is deleted.
 * 1. It is a leaf, simply return null.
 * 2. It only have one side sub tree, return the sub tree.
 * 3. It has two sub trees, then we find the min node in right tree recursively
 */
class Solution {
    private TreeNode findMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        
        return node;
    }
    
    private TreeNode deleteNodeHelper(TreeNode node, int key) {
        if (node == null) return node;
        
        if (key < node.val)
            node.left = deleteNodeHelper(node.left, key);
        else if (key > node.val)
            node.right = deleteNodeHelper(node.right, key);
        else { // found
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            
            TreeNode minNode = findMin(node.right);
            node.val = minNode.val;
            node.right = deleteNode(node.right, node.val);
        }

        return node;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNodeHelper(root, key);
    }
}