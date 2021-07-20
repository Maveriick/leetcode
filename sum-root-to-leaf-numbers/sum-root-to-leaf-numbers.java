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
    int totalSum = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root, new ArrayList<>());
        return totalSum;
    }
    
    private void traverse(TreeNode root, List<Integer> currentPath) {
        if(root == null) {
            return;
        }
       
        currentPath.add(root.val);
       
        if(root.left == null && root.right == null) {
            sum(currentPath);
            return;
        }
        traverse(root.left, new ArrayList<>(currentPath));
        traverse(root.right, new ArrayList<>(currentPath));        
    }
    
    private void sum(List<Integer> l) {
        System.out.println(l.toString());
        int sum = 0;
        for(int i = 0; i < l.size(); i++) {
            sum = (sum * 10) + l.get(i);
        }
        totalSum += sum;
    }
    //[1,2]
    
}