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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val, qVal = q.val;
        TreeNode node = root;
        
        while (node != null) {
            if (pVal > node.val && qVal > node.val) 
                node = node.right;
            else if (pVal < node.val && qVal < node.val) 
                node = node.left;
            else 
                return node;
        }
        
        return null;
    }
}