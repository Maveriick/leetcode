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
    Map<Integer, List<TreeNode>> levelMap = new HashMap<>();
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        traverse(root, 1);
        List<TreeNode> c = levelMap.get(depth - 1);
        if(depth == 1){
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }
        for(int i = 0; i < c.size(); i++) {
            TreeNode current = c.get(i);
           
                TreeNode n = new TreeNode(val);
                n.left = current.left;
                current.left = n;
            
            
        
                TreeNode n2 = new TreeNode(val);
                n2.right = current.right;
                current.right = n2;
            
        }
        return root;
        
    }
    
    private void traverse(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        traverse(root.left, depth + 1);
        List<TreeNode> current = levelMap.getOrDefault(depth, new ArrayList<>());
        current.add(root);
        levelMap.put(depth, current);
        traverse(root.right, depth + 1);
    }
}