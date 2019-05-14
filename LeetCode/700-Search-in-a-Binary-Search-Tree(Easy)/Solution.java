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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        
        TreeNode res;
        
        if (val == root.val)
            res = root;
        else if (val < root.val)
            res = searchBST(root.left, val);
        else
            res = searchBST(root.right, val);
        
        return res;
    }
}