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
    Set<TreeNode> toDelete = new HashSet<>();
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        traverse(root, target);
        if(toDelete.contains(root)){
            root = null;
            return null;
        }
        delete(root);
        return root;
    }
    
    
    private void delete(TreeNode root) {
        if(root == null){
            return;
        }
        
        if(root.left != null && toDelete.contains(root.left)) {
            root.left = null;
        }
        
        if(root.right != null && toDelete.contains(root.right)) {
            root.right = null;
        }
        
        delete(root.left);
        delete(root.right);
        
        
    }
    
    private void traverse(TreeNode root, int target) {
        if(root == null) {
            return;
        }
        traverse(root.left, target);
        traverse(root.right, target);
        if(root.left == null && root.right == null && root.val == target) {
            toDelete.add(root);
        }
        if(root.left != null && toDelete.contains(root.left) && root.right != null && toDelete.contains(root.right) && root.val == target) {
            toDelete.add(root);
        }
        
        if(root.left == null || root.right == null) {
            if(root.left == null && toDelete.contains(root.right) && root.val == target){
                toDelete.add(root);
            }
            
            if(root.right == null && toDelete.contains(root.left) && root.val == target){
                toDelete.add(root);
            }
        }
    }
}