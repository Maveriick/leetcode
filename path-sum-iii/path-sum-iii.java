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
    int paths = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return 0;
        }
        
        traverse(root, 0, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return paths;
    }
    
    
    private void traverse(TreeNode root, int currentSum, int targetSum){
        if(root == null) {
            return;
        }
        
        currentSum += root.val;
        if(currentSum == targetSum) {
            paths ++;
        }
        
        traverse(root.left, currentSum, targetSum);
        traverse(root.right, currentSum , targetSum);
        
        
    }
}