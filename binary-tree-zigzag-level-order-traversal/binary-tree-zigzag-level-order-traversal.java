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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<List<Integer>> sol = new ArrayList<>();
        if(root == null) {
            return sol;
        }
        s1.push(root);
        boolean keepGoing = true;
        
        while(keepGoing) {
            if(s1.isEmpty() && s2.isEmpty()){
                break;
            }
           
            List<Integer> s = new ArrayList<>();
            while(!s1.isEmpty()){
                
                TreeNode r = s1.pop();
                s.add(r.val);
                
                if(r.left != null) {
                     s2.push(r.left);
                }
                
                 if(r.right != null) {
                     s2.push(r.right);
                }
            }
            if(!s.isEmpty()){
                 sol.add(s);
            }
           
            
            List<Integer> s4 = new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode r = s2.pop();
                s4.add(r.val);
                
                if(r.right != null) {
                     s1.push(r.right);
                }
                
                if(r.left != null) {
                     s1.push(r.left);
                }
                
            }
            if(!s4.isEmpty()) {
                  sol.add(s4);
            }
           
        }
        return sol;
        
    }
}