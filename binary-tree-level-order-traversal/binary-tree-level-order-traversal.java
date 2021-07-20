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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> sol = new ArrayList<>();
        if(root == null) {
            return sol;
        }
        while(!q.isEmpty()) {
            int size = q.size();
            Queue<TreeNode> temp = new LinkedList<>();
            List<Integer> partial = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode c = q.remove();
                partial.add(c.val);
                if(c.left != null) {
                    temp.add(c.left);
                }
                
                if(c.right != null) {
                    temp.add(c.right);
                }
            }
            q.addAll(temp);
            sol.add(partial);
        }
        return sol;
    }
}