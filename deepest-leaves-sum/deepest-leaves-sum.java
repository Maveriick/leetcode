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
    Map<Integer, List<Integer>> deepestLeaves = new HashMap<>();
    int deepest = 0;
    public int deepestLeavesSum(TreeNode root) {
        
        if(root == null) {
            return 0;
            
        }
        traverse(root, 0);
        List<Integer> l = deepestLeaves.get(deepest);
        int sum = 0;
        for(int i = 0; i < l.size(); i++){
            sum += l.get(i);
        }
        
        return sum;
    }
    
    
    private void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        deepest = Math.max(deepest, level);
        
        List<Integer> current = deepestLeaves.getOrDefault(level, new ArrayList<>());
        current.add(root.val);
        deepestLeaves.put(level, current);
        
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
        
    }
}