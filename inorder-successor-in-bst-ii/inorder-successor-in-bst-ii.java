/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        // Check right
        Node runner = node;
        if(runner.right != null) {
            runner = runner.right;
            while(runner.left != null) {
                runner = runner.left;
            }
            return runner;
        } else {
            Node parent = runner.parent;
            while(parent != null && parent.val < node.val){
                parent = parent.parent;
            }
            if(parent != null){
                return parent;
            } 
            
            return null;
           
        }
    }
}