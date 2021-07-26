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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }
        
        if(root.left == null && root.right == null) {
            if(root.val == key) {
                return null;
            } else {
                return root;
            }
        }
        TreeNode runner = root;
        TreeNode prev = null;
        while(runner != null && runner.val != key) {
            prev = runner;
            if(runner.val < key) {
                runner = runner.right;
            } else {
                runner = runner.left;
            }
        }
        
        if(runner == null) {
            return root;
        }
        
     
        // Has no child
        if(runner.left == null && runner.right == null) {
            if(prev.right == runner) {
                prev.right = null;
            } else {
                prev.left = null;
            }
        } else if(runner.left == null || runner.right == null) {
            if(prev == null) {
                if(runner.right != null){
                    runner.val = runner.right.val;
                    runner.right = null;
                } else {
                    runner.val = runner.left.val;
                    runner.left = null;
                }
                return root;
            }
            
            // Has right child
            if(runner.left == null) {
                if(prev.val < key) {
                    prev.right = runner.right;
                } else {
                    prev.left = runner.right;
                }
            } else {
                 if(prev.val < key) {
                    prev.right = runner.left;
                } else {
                    prev.left = runner.left;
                }
            }
        } else {
            TreeNode right = runner.right;
            TreeNode p = runner;
            while(right.left != null){
                p = right;
                right = right.left;
            }
            
            runner.val = right.val;
            
            if (right == p.left) p.left = right.right;
            else
                p.right = right.right;
            return root;
           
        }
        return root;
        
    }
}