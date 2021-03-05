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

class Node {
    public int sum;
    public int nodes;
    public Node(int sum, int nodes) {
        this.sum = sum;
        this.nodes = nodes;
    }
}
class Solution {
    double maxAvg = Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        traverse(root);
        return maxAvg;
    }
    
    private Node traverse(TreeNode root){
        if(root == null){
            return null;
        }
        
        Node leftSubTree = traverse(root.left);
        Node rightSubTree = traverse(root.right);
        
        int totalSum = root.val;
        int totalNodes = 1;
        if(leftSubTree != null){
            totalSum += leftSubTree.sum;
            totalNodes += leftSubTree.nodes;
        }
        
        if(rightSubTree != null){
            totalSum += rightSubTree.sum;
            totalNodes += rightSubTree.nodes;
        }
        
        double avg = totalSum / (double) totalNodes;
        maxAvg = Math.max(maxAvg, avg);
        return new Node(totalSum, totalNodes);
    }
}