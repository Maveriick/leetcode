/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Set<TreeNode> existing = new HashSet<>();
    Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root);
        while(p != null){
            existing.add(p);
            p = childParentMap.get(p);
        }
        
        while(q != null){
            if(existing.contains(q)){
                return q;
            }
            q = childParentMap.get(q);
        }
        
        return null;
       
        
        
    }
    
    private void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            childParentMap.put(root.left, root);
            traverse(root.left);
        }
        
        if(root.right != null) {
            childParentMap.put(root.right, root);
            traverse(root.right);
        }
    }
}