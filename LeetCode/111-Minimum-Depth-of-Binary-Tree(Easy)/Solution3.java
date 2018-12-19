import javax.swing.tree.TreeNode;

import sun.misc.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * 
 * Iterative BFS:
 * Two methods: One is general BFS, iterate all nodes. The other onde is return
 * the depth once we touches the leaf.
 * 
 */
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int minDepth = Integer.MAX_VALUE;
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            while (levelSize > 0) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
                if (curr.left == null && curr.right == null)
                    minDepth = Math.min(minDepth, depth);
                    // return depth;  directly return depth can avoid iterating all nodes.

                --levelSize;
            }

            ++depth;
        }

        return minDepth;
    }
}