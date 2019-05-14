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
    private TreeNode helper(int[]nums, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        
        node.left = helper(nums, start, mid - 1);
        node.right = helper(nums, mid + 1, end);
        
        return node;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}