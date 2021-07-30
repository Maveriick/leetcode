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
    int longestSequence = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        traverse(root, root.val - 1, 1);
        longestConsecutive(root.left);
        longestConsecutive(root.right);
        return longestSequence;
    }
    
    private void traverse(TreeNode root, int previousValue, int currentLength) {
    
        if(root == null) {
            return ;
        }
        if(root.val - previousValue == 1) {
            longestSequence = Math.max(currentLength, longestSequence);
            traverse(root.left, root.val, currentLength + 1);
            traverse(root.right, root.val, currentLength + 1);
        } 
    }
}