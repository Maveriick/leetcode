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
    List<Integer> sol = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        traverse(root);
        for(int i = 0; i < sol.size() - 1; i++){
            if(sol.get(i + 1) <= sol.get(i)){
                return false;
            }
        }
        return true;
    }
    
    private void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        
        traverse(root.left);
        sol.add(root.val);
        traverse(root.right);
    }
}