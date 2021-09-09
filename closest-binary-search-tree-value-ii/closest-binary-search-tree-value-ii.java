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
    int value;
    Double distance;
    public Node(int value, double target) {
        this.value = value;
        this.distance = getDistance(target);
    }
    
    private double getDistance(double target) {
        return Math.abs(target - value);
    }
}
class Solution {
    PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.distance.compareTo(a.distance));
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> solution = new ArrayList<>();
        if (root == null) {
            return solution;
        }
        traverse(root, target, k);
        while(!pq.isEmpty()) {
            solution.add(pq.poll().value);
        }
        return solution;
    }
    
    private void traverse(TreeNode root, double target, int k) {
        if (root == null) {
            return;
        }
        
        traverse(root.left, target, k);
        Node node = new Node(root.val, target);
        if(pq.size() < k) {
            pq.add(node);
        } else {
            if(node.distance < pq.peek().distance) {
                pq.poll();
                pq.add(node);
            }
        }
        traverse(root.right, target, k);
    }
}