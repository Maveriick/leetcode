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
    int goodNodes = 0;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return goodNodes;
        }
        traverse(root, root.val);
        return goodNodes;
    }
    
    private void traverse(TreeNode root, int currentMax){
        if(root == null){
            return;
        }
        
        if(root.val >= currentMax){
            goodNodes++;
        }
        
        traverse(root.left, Math.max(root.val, currentMax));
        traverse(root.right, Math.max(root.val,  currentMax));
    }
}