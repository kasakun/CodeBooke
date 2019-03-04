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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (k != 0) {
            node = stack.pop();
            --k;

            TreeNode right = node.right;
            while (k != 0) {
                stack.push(right);
                right = right.left;
            }
        }

        return -1;
    }
}