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
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int count = 0;
        if(traverse(root, root.val)){
            count++;
        }
        int left = countUnivalSubtrees(root.left);
        int right = countUnivalSubtrees(root.right);
        return count + left + right;
    }
    
    
    private boolean traverse(TreeNode root, int expectedVal) {
        if(root == null) {
            return true;
        }
        
        if(root.val != expectedVal) {
            return false;
        }
        
        return traverse(root.left, expectedVal) && traverse(root.right, expectedVal);
    }
}