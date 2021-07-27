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
    Map<Integer, List<TreeNode>> deepestLeaves = new HashMap<>();
    int maxLevel = 0;
    Map<TreeNode ,TreeNode> childParentMap = new HashMap<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        traverse(root, 0);
        List<TreeNode> deepest = deepestLeaves.get(maxLevel);
        print(deepest);
        if(deepest.size() == 1){
            return deepest.get(0);
        }
        Set<TreeNode> exists = new HashSet<>();
       
        
         TreeNode first = deepest.get(0);
         while(first != null){
           exists.add(first);
            first = childParentMap.get(first);
        }
        
        TreeNode last = deepest.get(deepest.size() - 1);
        while(last != null){
            if(exists.contains(last)){
                return last;
            }
            
            last = childParentMap.get(last);
        }
        return null;
        
        
    }
    
    private void traverse(TreeNode root, int level) {
        if(root == null) {
            return;
        }
        
        if(root.left != null){
            childParentMap.put(root.left, root);
        }
        
        if(root.right != null) {
            childParentMap.put(root.right, root);
        }
        maxLevel = Math.max(maxLevel, level);
        traverse(root.left, level + 1);
        List<TreeNode> cl = deepestLeaves.getOrDefault(level, new ArrayList<>());
        cl.add(root);
        deepestLeaves.put(level, cl);
        traverse(root.right, level + 1);
    }
    
    private void print(List<TreeNode> deepest){
        for(int i = 0; i < deepest.size(); i++) {
            System.out.print(deepest.get(i).val);
            System.out.print(",");
        }
    }
}