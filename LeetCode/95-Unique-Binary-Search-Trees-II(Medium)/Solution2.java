/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * dp
 */
class Solution2 {
    private TreeNode clone(TreeNode node) {
        if (node == null) return node;

        TreeNode root = new TreeNode(node.val);
        
        root.left = clone(node.left);
        root.right = clone(node.right);
        
        return root;
        
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = new ArrayList<>();
        if (n == 0) return res;
        
        res.add(null);

        for (int  i = 1; i <= n; ++i) {
            List<TreeNode> temp = new ArrayList<>();
            
            for (TreeNode oldRoot : res) {
                TreeNode newNode = new TreeNode(i);
                
                // i. add old tree to the newNode left
                newNode.left = clone(oldRoot);
                temp.add(newNode);
                
                //ii. add newNode to old tree
                if (oldRoot == null) continue;
                
                /** We modify the old tree we get from res
                 * The reason is we are traversing the old tree
                 */
                TreeNode node = oldRoot;
                while (node.right != null) {
                    TreeNode rightSubTree = node.right;
                    newNode = new TreeNode(i);

                    // insert
                    newNode.left = node.right;
                    node.right = newNode;
                    
                    // oldRoot currently is a new Tree
                    temp.add(clone(oldRoot));
                    
                    // restore the tree and go to next
                    node.right = rightSubTree;
                    node = node.right;
                }
                
                //iii. add to the end of the tree
                newNode = new TreeNode(i);
                node.right = newNode;
                temp.add(clone(oldRoot));

                // restore the tree
                node.right = null;
            }
            res = new ArrayList<>(temp);
        }
        
        return res;
    }
}