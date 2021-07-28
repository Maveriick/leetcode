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
    Set<TreeNode> visitedRoots = new HashSet<>();
    List<List<Integer>> sol = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null) {
            return sol;
        }
        
        while(!visitedRoots.contains(root)){
            List<Integer> partial = new ArrayList<>();
            traverse(root, partial);
            sol.add(new ArrayList<>(partial));
        }
        return sol;
    }
    
    private void traverse(TreeNode root, List<Integer> partialSolution){
        if(root == null){
            return;
        }
        
     
        if(root.left == null  && root.right == null){
            partialSolution.add(root.val);
            visitedRoots.add(root);
        } else if(root.left != null && visitedRoots.contains(root.left) && root.right != null && visitedRoots.contains(root.right)) {
            partialSolution.add(root.val);
            visitedRoots.add(root);
        } else if( root.left == null && root.right != null && visitedRoots.contains(root.right)){
            partialSolution.add(root.val);
            visitedRoots.add(root);
        } else if(root.right == null && root.left != null && visitedRoots.contains(root.left)) {
            partialSolution.add(root.val);
            visitedRoots.add(root);
        }
        
        if(root.left != null && !visitedRoots.contains(root.left)){
            traverse(root.left, partialSolution);
        }
        
        if(root.right != null && !visitedRoots.contains(root.right)) {
             traverse(root.right, partialSolution);
        }
       
    }
    
    
}