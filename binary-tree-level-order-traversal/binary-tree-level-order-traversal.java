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
    List<List<Integer>> solution = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return solution;
        }
        
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.add(root);
        
        while(!bfsQ.isEmpty()) {
            List<Integer> partialSolution = new ArrayList<>();
            List<TreeNode> tempList = new ArrayList<>();
            int size = bfsQ.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = bfsQ.remove();
                partialSolution.add(current.val);
                if(current.left != null) {
                    tempList.add(current.left);
                }
                
                if(current.right != null) {
                    tempList.add(current.right);
                }
            }
            solution.add(partialSolution);
            bfsQ.addAll(tempList);
        }
        return solution;
    }
}