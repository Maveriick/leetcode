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
    List<Integer> indexes = new ArrayList<>();
    public boolean isCompleteTree(TreeNode root) {
        traverse(root, 0);
        Collections.sort(indexes);
        System.out.println(indexes.toString());
        for(int i = 0; i < indexes.size() -1; i++){
            if(indexes.get(i + 1) - indexes.get(i) > 1){
                return false;
            }
        }
        return true;
    }
    
    
    private void traverse(TreeNode root, int currentIndex){
        if(root == null){
            return;
        }
        
        indexes.add(currentIndex);
        traverse(root.left, 2 * currentIndex + 1);
        traverse(root.right, 2 * currentIndex + 2);
    }
    
    
}