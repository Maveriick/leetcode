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
    int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        traverse(root.left, root.val);
        traverse(root.right, root.val);
        maxAncestorDiff(root.left);
        maxAncestorDiff(root.right);
        return maxDiff;
    }
    
    private void traverse(TreeNode root, int rootValue) {
        if(root == null) {
            return;
        }
        
        maxDiff = Math.max(maxDiff, Math.abs(root.val - rootValue));
        traverse(root.left, rootValue);
        traverse(root.right, rootValue);
        
        
    }
}