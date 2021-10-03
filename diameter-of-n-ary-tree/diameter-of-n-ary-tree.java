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
    int maxDiameter = 0;
    public int diameter(Node root) {
        if(root == null) {
            return maxDiameter;
        }
        diameterRecursive(root);
        return maxDiameter;
    }
    
    private int diameterRecursive(Node root) {
       
        
        int max1 = 0;
        int max2 = 0;
        List<Node> children = root.children;
        for(int i = 0; i < children.size(); i++) {
            int diameterChild = 1 + diameterRecursive(children.get(i));
            if(diameterChild > max1) {
                max2 = max1;
                max1 = diameterChild;
            }else if(diameterChild > max2) {
                max2 = diameterChild;
            }
            
            
        }
        maxDiameter = Math.max(maxDiameter, max1 + max2);
        return Math.max(max1, max2);
    }
    
    /*
    private int depth(Node root) {
        int d1 = 0;
        int d2 = 0;
        
        
        List<Node> children = root.children;
        for(int i = 0; i < children.size(); i++) {
            int childDiameter = 1 + depth(children.get(i));
            if(childDiameter > d1){
                d2 = d1;
                d1 = childDiameter;
            } else if(childDiameter > d2) {
                d2 = childDiameter;
            }
            
        }
        
        maxDiamter = Math.max(maxDiamter, d1 + d2);
        return Math.max(d1, d2);
    }
    */
}