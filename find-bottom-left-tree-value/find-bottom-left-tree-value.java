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
    int maxLevel = 1;
    Map<Integer, List<Integer>> m = new HashMap<>();
    public int findBottomLeftValue(TreeNode root) {
        traverse(root, 1);
        return m.get(maxLevel).get(0);
        
    }
    
    private void traverse(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        
        maxLevel = Math.max(level, maxLevel);
        traverse(root.left, level + 1);
        List<Integer> c = m.getOrDefault(level, new ArrayList<>());
        c.add(root.val);
        m.put(level, c);
        traverse(root.right, level + 1);
    }
}