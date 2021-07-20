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
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        traverse(root, false ,false);
        return sum;
    }
    
    
    private void traverse(TreeNode root, boolean isEvenParent, boolean isEvenGrandParent) {
        if(root == null) {
            return;
        }
        
        if(isEvenGrandParent) {
            sum += root.val;
        }
        
        traverse(root.left, root.val % 2 == 0, isEvenParent);
        traverse(root.right, root.val % 2 == 0, isEvenParent);

        
    }
    
    
}