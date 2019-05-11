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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        
        queue.add(root);
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> list = new LinkedList<>();
            while(size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                --size;
            }
            stack.push(list);
        }
        
        while (!stack.isEmpty()) res.add(stack.pop());
        
        return res;
    }
}