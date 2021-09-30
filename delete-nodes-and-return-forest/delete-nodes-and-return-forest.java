/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<TreeNode> solution = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root == null) {
            return solution;
        }
        
        Set<Integer> toDelete = new HashSet<>();
        for(int i = 0; i < to_delete.length; i++){
            toDelete.add(to_delete[i]);
        }
        root = dfs(root, toDelete);
        if(root != null){
            solution.add(root);
        }
        return solution;
    }
    
    private TreeNode dfs(TreeNode root, Set<Integer> doDelete){
        if(root == null) {
            return null;
        }
        
        root.left = dfs(root.left, doDelete);
        root.right = dfs(root.right, doDelete);
        
        if(doDelete.contains(root.val)){
            if(root.left != null) {
                solution.add(root.left);
            }
            
            if(root.right != null) {
                solution.add(root.right);
            }
            root = null;
        }
        return root;
    }
}