/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    Map<Integer, List<Node>> levelMap = new HashMap<>();
    int maxLevel = 0;
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        
        traverse(root, 0);
        for(int i = 0; i <= maxLevel; i++) {
            List<Node> cl = levelMap.get(i);
            for(int j = 0; j < cl.size() - 1; j++) {
                cl.get(j).next = cl.get(j + 1);
            }
            cl.get(cl.size() - 1).next = null;
        }
        
        return root;
        
    }
    
    private void traverse(Node root, int level) {
        if(root == null) {
            return;
        }
        
        maxLevel = Math.max(maxLevel, level);
        traverse(root.left, level + 1);
        List<Node> cl = levelMap.getOrDefault(level, new ArrayList<>());
        cl.add(root);
        levelMap.put(level, cl);
        traverse(root.right, level + 1);
        
        
        
    }
}