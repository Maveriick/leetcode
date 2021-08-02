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
   
    public TreeNode correctBinaryTree(TreeNode root) {
        TreeNode nodeToDelete = null;
        Set<TreeNode> visited;
        visited = new HashSet<>();
        
        Queue<TreeNode> initialBfsQ = new LinkedList<>();
        initialBfsQ.add(root);
        visited.add(root);
        while(!initialBfsQ.isEmpty()) {
            TreeNode current = initialBfsQ.remove();
            if(current.right != null) {
                if(visited.contains(current.right)) {
                    nodeToDelete = current;
                    break;
                } else {
                    visited.add(current.right);
                    initialBfsQ.add(current.right);
                }
            }
            
            if(current.left != null) {
                if(visited.contains(current.left)) {
                    nodeToDelete = current.left;
                    break;
                } else {
                    visited.add(current.left);
                    initialBfsQ.add(current.left);
                }
            }
        }
        
        System.out.println(nodeToDelete.val);
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.add(root);
        Set<TreeNode> bfsVisit = new HashSet<>();
        while(!bfsQ.isEmpty()) {
            TreeNode current = bfsQ.remove();
            if(current.left != null) {
                if(current.left == nodeToDelete) {
                    current.left = null;
                } else {
                    if(!bfsVisit.contains(current.left)){
                        bfsVisit.add(current.left);
                        bfsQ.add(current.left);
                    }
                }
            }
            
            if(current.right != null) {
                if(current.right == nodeToDelete) {
                    current.right = null;
                } else {
                    if(!bfsVisit.contains(current.right)){
                        bfsVisit.add(current.right);
                        bfsQ.add(current.right);
                    }
                }
            }
        }
        return root;
    }
}