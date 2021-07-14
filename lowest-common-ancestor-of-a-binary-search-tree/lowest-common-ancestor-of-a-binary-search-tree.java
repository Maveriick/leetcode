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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode runner = root;
        while(runner != null) {
            System.out.println(runner.val);
            if(p.val <= runner.val && runner.val <= q.val || p.val >= runner.val && runner.val >= q.val){
                return runner;
            } else if(p.val <= runner.val && q.val <= runner.val){
                runner = runner.left;
            } else {
                runner = runner.right;
            }
        }
        return runner;
    }
}