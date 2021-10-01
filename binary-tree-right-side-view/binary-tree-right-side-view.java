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
    List<Integer> solution = new ArrayList<>();
    int maxLevel = -1;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return solution;
        }
        traverse(root, 0);
        return solution;
    }
    
    private void traverse(TreeNode root, int currentLevel) {
        if(root == null) {
            return;
        }
        
        if(currentLevel > maxLevel){
            solution.add(root.val);
            maxLevel = Math.max(maxLevel, currentLevel);
        }
        
        
        traverse(root.right, currentLevel + 1);
        traverse(root.left, currentLevel + 1);
    }
}