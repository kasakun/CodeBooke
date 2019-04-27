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
    Map<Integer, Integer> map = new HashMap<>();

    private int dfs(TreeNode node, int parentValue, int target, int depth) {
        if (node == null) return -1;
        if (node.val == target) {map.put(node.val, parentValue); return depth + 1;}
        
        int left, right;
        
        left = dfs(node.left, node.val, target, depth + 1);
        
        right = dfs(node.right, node.val, target, depth + 1);
        
        return left > right? left : right;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        int depthX = 0, depthY = 0;
        
        depthX = dfs(root, 0, x, 0);
        depthY = dfs(root, 0, y, 0);
        
        return (depthX == depthY) && (map.get(x) != map.get(y));
    }
}