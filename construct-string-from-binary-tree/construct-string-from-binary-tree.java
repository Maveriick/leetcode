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
    
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildTree(root, sb);
        return sb.toString();
    }
    
    private void buildTree(TreeNode root, StringBuilder sb) {
       if(root == null) {
           return;
       }
        
       Integer current = root.val;
        sb.append(Integer.toString(current));
        
        if(root.left != null) {
            sb.append("(");
            buildTree(root.left, sb);
            sb.append(")");
        } else {
            if(root.right != null){
                sb.append("()");
            }
            
        }
        
        if(root.right != null) {
            sb.append("(");
            buildTree(root.right, sb);
            sb.append(")");
        } else {
            
        }
    }
}