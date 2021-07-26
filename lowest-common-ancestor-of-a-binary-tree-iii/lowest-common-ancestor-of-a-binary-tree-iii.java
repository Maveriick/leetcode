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
    Set<Node> existing = new HashSet<>();
    public Node lowestCommonAncestor(Node p, Node q) {
    
        while(p != null){
            existing.add(p);
            p = p.parent;
        }
        System.out.println(existing.toString());
        
        while(q != null){
            if(existing.contains(q)){
                return q;
            }
            q = q.parent;
        }
        
        return null;
    }
}