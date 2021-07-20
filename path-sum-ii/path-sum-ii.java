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
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        traverse(root, new ArrayList<>(), 0, targetSum);
        return solution;
    }
    
    private void traverse(TreeNode root, List<Integer> currentPath, int currentSum, int targetSum) {
        if(root == null) {
            return;
        }
       
        currentSum += root.val;
        currentPath.add(root.val);
       
        if(currentSum == targetSum) {
            if(root.left == null && root.right == null) {
                solution.add(new ArrayList<>(currentPath));
            }
        }
        traverse(root.left, new ArrayList<>(currentPath) ,currentSum, targetSum);
        traverse(root.right, new ArrayList<>(currentPath) ,currentSum, targetSum);        
    }
}