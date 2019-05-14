/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Iterative DFS:
 * Time O(n)
 * Space O(n) (worst, completely unbalanced)
 *       O(logn) (best, completely balanced)
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        int depth = 1;
        int minDepth = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode peekNode = stack.peek();

            if (peekNode.left != null) {
                stack.push(peekNode.left);
            }

            if (peekNode.right != null) {
                stack.push(peekNode.right);
            }

            if (peekNode.left == null && peekNode.right == null) {
                minDepth = Math.min(depth, minDepth);
                // go back to the branch      
                TreeNode popNode = stack.pop();
                while (popNode != null && !stack.isEmpty()) {
                    peekNode = stack.peek();
                    if (isParentChild(peekNode, popNode)) {
                        --depth;
                        popNode = stack.pop();
                    } else {
                        break;
                    }                    
                }
            } else {
                ++depth;
            }
        }
        return minDepth;
    }

    private boolean isParentChild(TreeNode parent, TreeNode child) {
        return (child == parent.left || child == parent.right);
    }
}