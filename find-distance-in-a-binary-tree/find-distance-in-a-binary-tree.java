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
    Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
     Map<Integer, TreeNode> nodeMap = new HashMap<>();
    
    public int findDistance(TreeNode root, int p, int q) {
         traverse(root, p, q);
         int distance = 0;
        
        if (p == q) {
            return 0;
        }
        
        Queue<TreeNode> bfsQ = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        bfsQ.add(nodeMap.get(p));
        boolean keepGoing = true;
        while(!bfsQ.isEmpty()) {
            int size = bfsQ.size();
           
            for(int j = 0; j < size; j++) {
                TreeNode n = bfsQ.remove();
                visited.add(n);
                
                if(n == nodeMap.get(q)){
                    return distance ;
                }
                
                if(n.left != null && !visited.contains(n.left)){
                    bfsQ.add(n.left);
                }
                
                if(n.right != null && !visited.contains(n.right)){
                    bfsQ.add(n.right);
                }
                
                if(childParentMap.containsKey(n) && !visited.contains(childParentMap.get(n))){
                    bfsQ.add(childParentMap.get(n));
                }
                
            }
             distance++;
        }
        return -1;
    }
    
    private void traverse(TreeNode root, int p, int q) {
        if(root == null) {
            return;
        }
        
        nodeMap.put(root.val, root);
        
        if(root.left != null) {
            childParentMap.put(root.left, root);
            traverse(root.left, p, q);
        }
        
        if(root.right != null) {
            childParentMap.put(root.right, root);
            traverse(root.right, p, q);
        }
    }
}