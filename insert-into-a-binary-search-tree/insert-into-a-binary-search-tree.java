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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }
        TreeNode runner = root;
        TreeNode prev = null;
        while(runner != null) {
            prev = runner;
            if(runner.val < val) {
                runner = runner.right;
            } else {
                runner = runner.left;
                
            }
        }
        
        if(prev.val < val) {
            prev.right = new TreeNode(val);
        } else {
            prev.left = new TreeNode(val);
        }
        return root;
    }
}