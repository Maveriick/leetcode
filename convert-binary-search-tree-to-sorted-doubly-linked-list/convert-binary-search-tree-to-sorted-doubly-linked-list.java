/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node dummy = new Node(-1);
    Node prev = dummy;
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return root;
        }
        traverse(root);
        Node last = dummy;
        Node solPtr = dummy.right;
        while(last.right != null) {
            last = last.right;
        }
        last.right = solPtr;
        solPtr.left = last;
        return solPtr;
        
        
    }
    
    private void traverse(Node root) {
        if(root == null) {
            return;
        }
        
        traverse(root.left);
        root.left = prev;
        prev.right = root;
        prev = root;
        traverse(root.right);
    }
}