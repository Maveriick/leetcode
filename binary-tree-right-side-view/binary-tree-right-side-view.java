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
    int maxLevel = 0;
    Map<Integer, List<Integer>> levelMap = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        
        traverse(root, 0);
        List<Integer> sol = new ArrayList<>();
        if(root == null) {
            return sol;
        }
        for(int i = 0; i <= maxLevel; i++) {
            sol.add(levelMap.get(i).get(levelMap.get(i).size() - 1));
        }
        return sol;
    }
    
    private void traverse(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        
        maxLevel = Math.max(maxLevel, level);
        traverse(root.left, level + 1);
        List<Integer> current = levelMap.getOrDefault(level, new ArrayList<>());
        current.add(root.val);
        levelMap.put(level, current);
        traverse(root.right, level + 1);
    }
}