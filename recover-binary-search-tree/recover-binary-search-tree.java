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
    TreeNode prev = null;
    TreeNode correct1 = null;
    TreeNode correct2 = null;
    public void recoverTree(TreeNode root) {
        solve(root);
        
        int temp = correct1.val;
        correct1.val = correct2.val;
        correct2.val = temp;
    
    }
    
    private void solve(TreeNode root) {
        if(root == null) {
            return;
        }
        
        solve(root.left);
        if(prev != null) {
            if(prev.val > root.val){
                if(correct1 == null){
                    correct1 = prev;
                }
                correct2 = root;
            }
        }
        
        prev = root;
        solve(root.right);
    }
}