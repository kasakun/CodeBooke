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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> list = new ArrayList<>();
        
        pathSumHelper(root, res, list, sum);
        
        return res;
    }
    
    private void pathSumHelper(TreeNode node,
                               List<List<Integer>> res,
                               List<Integer> list,
                               int remainSum) {
        if (node.left == null && node.right == null) {
            if (remainSum == node.val) {
                list.add(node.val);
                res.add(new ArrayList<Integer>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        
        list.add(node.val);

        if (node.left != null)
            pathSumHelper(node.left, res, list, remainSum - node.val);
        if (node.right != null)
            pathSumHelper(node.right, res, list, remainSum - node.val);
        list.remove(list.size() - 1);
    }
}