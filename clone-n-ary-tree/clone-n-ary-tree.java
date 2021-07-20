/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    Map<Node, Node> m = new HashMap<>();
    public Node cloneTree(Node root) {
        return clone(root);
    }
    
    private Node clone(Node root) {
        if(root == null) {
            return null;
        }
        
        if(m.containsKey(root)){
            return m.get(root);
        }
        
        Node cloneRoot = new Node(root.val);
        m.put(root, cloneRoot);
        List<Node> children = root.children;
        List<Node> cloneChildren = new ArrayList<>();
        for(int i = 0; i < children.size(); i++) {
            cloneChildren.add(clone(children.get(i)));
        }
        cloneRoot.children = cloneChildren;
        return cloneRoot;
    }
}