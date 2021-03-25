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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        traverse(root, val, depth, 1);
        return root;
    }
    
    
    private void traverse(TreeNode root, int val, int depth, int currentDepth) {
        if(root == null) {
            return;
        }
        
        traverse(root.left, val, depth, currentDepth + 1);
        
        if(currentDepth == depth - 1){
            TreeNode leftNode = new TreeNode(val);
            TreeNode rightNode = new TreeNode(val);
            leftNode.left = root.left;
            rightNode.right = root.right;
            root.left = leftNode;
            root.right = rightNode;
        }
        
        traverse(root.right, val, depth, currentDepth + 1);
    }
}