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
    TreeNode root;
    int level; 
    
    public Node(TreeNode root, int level) {
        this.root = root;
        this.level = level;
    }
}

class Solution {
    int min = 0;
    int max = 0;
    Map<Integer, List<Integer>> levelMap = new HashMap<>();
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
         List<List<Integer>> solution = new ArrayList<>();
        
        if(root == null) {
            return solution;
        }
       
        Queue<Node> bfsQ = new LinkedList<>();
        bfsQ.add(new Node(root, 0));
        
        while(!bfsQ.isEmpty()) {
            Node current = bfsQ.remove();
            List<Integer> currentAtLevel = levelMap.getOrDefault(current.level, new ArrayList<>());
            currentAtLevel.add(current.root.val);
            levelMap.put(current.level, currentAtLevel);
            min = Math.min(min, current.level);
            max = Math.max(max, current.level);
            
            if(current.root.left != null) {
                bfsQ.add(new Node(current.root.left, current.level - 1));
            }
            
            if(current.root.right != null) {
                bfsQ.add(new Node(current.root.right, current.level + 1));
            }
        }
        
        for(int i = min; i <= max; i++) {
            solution.add(levelMap.get(i));
        }
        return solution;
        
    }
}