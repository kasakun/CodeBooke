/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * 
 * The key is node poped out from preorder is always the top.
 * And then find the same element in the inorder list.
 */
import javafx.util.Pair;

class Solution {
    private Pair<TreeNode, int[]> buildTreeHelper(int[] preorder, int[] inorder) {
        if (inorder.length == 0)
            return new Pair(null, preorder);
        
        int index = 0;
        TreeNode root = new TreeNode(preorder[0]);
        
        for (;(index < inorder.length) && (inorder[index] != preorder[0]); ++index);
        
        preorder = Arrays.copyOfRange(preorder, 1, preorder.length);
        
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
        int[] rightInorder = index < inorder.length ?
                             Arrays.copyOfRange(inorder, index + 1, inorder.length) :
                             new int[0];
        
        Pair<TreeNode, int[]> pair = buildTreeHelper(preorder, leftInorder);
        root.left = pair.getKey();
        preorder = pair.getValue();
        pair = buildTreeHelper(preorder, rightInorder);
        root.right = pair.getKey();
        preorder = pair.getValue();
        
        return new Pair(root, preorder);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Pair<TreeNode, int[]> result = buildTreeHelper(preorder, inorder);
        return result.getKey();
    }
}