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
    Map<Integer, List<TreeNode>> levelNodes = new HashMap<>();
    int nodeLevel = 0;
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        traverse(root, 0, u);
        List<TreeNode> l = levelNodes.get(nodeLevel);
        TreeNode runner = null;
        int index = 0;
        for(int i = 0; i < l.size(); i++){
            if(l.get(i) == u){
                index = i;
                break;
            }
        }
        if(index < l.size() - 1){
            return l.get(index + 1);
        } else {
            return null;
        }
        
    }
    
    private void traverse(TreeNode root, int level, TreeNode u) {
        if(root == null) {
            return;
        }
        if(root == u){
            nodeLevel = level;
        }
        
        traverse(root.left, level + 1,u);
        List<TreeNode> c = levelNodes.getOrDefault(level, new ArrayList<>());
        c.add(root);
        levelNodes.put(level, c);
        traverse(root.right, level + 1, u);
    }
    
    
}