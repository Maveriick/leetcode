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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> r1L = new ArrayList<>();
        inOrder(root1, r1L);
        
        List<Integer> r2L = new ArrayList<>();
        inOrder(root2, r2L);
        
        Set<Integer> needed = new HashSet<>();
        for(int i = 0; i < r1L.size(); i++) {
            int complement = target - r1L.get(i);
            if(r2L.contains(complement)){
                return true;
            }
        }
        
        return false;
    }
    
    private void inOrder(TreeNode root, List<Integer> inOrderList) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left, inOrderList);
        inOrderList.add(root.val);
        inOrder(root.right, inOrderList);
    }
}