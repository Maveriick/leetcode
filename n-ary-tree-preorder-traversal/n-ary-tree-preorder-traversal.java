/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> sol = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        traverse(root, sol);
        return sol;
    }
    
    private void traverse(Node root, List<Integer> solution){
        if(root == null) {
            return;
        }
        
        solution.add(root.val);
        List<Node> children = root.children;
        for(int i = 0; i < children.size(); i++) {
            traverse(children.get(i), solution);
        }
    }
}