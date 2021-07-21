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
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
         List<Integer> solution = new ArrayList<>();
        if(root == null) {
            return solution;
        }
        traverse(root);
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.add(target);
        Set<TreeNode> visited = new HashSet<>();
       
        
        int distance = 0;
        while(!bfsQ.isEmpty()) {
            Queue<TreeNode> temp = new LinkedList<>();
            int size = bfsQ.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = bfsQ.remove();
                visited.add(current);
                if(distance == k) {
                    solution.add(current.val);
                }
                if(current.left != null && !visited.contains(current.left)) {
                    temp.add(current.left);
                }
                
                if(current.right != null && !visited.contains(current.right)) {
                    temp.add(current.right);
                }
                
                if(parentMap.containsKey(current) && !visited.contains(parentMap.get(current))) {
                    temp.add(parentMap.get(current));
                }
            }
            
            bfsQ.addAll(temp);
            distance++;
        }
        return solution;
    }
    
    private void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(root.left != null) {
            parentMap.put(root.left, root);
        }
        traverse(root.left);
        
        if(root.right != null) {
            parentMap.put(root.right, root);
        }
        traverse(root.right);
    }
}