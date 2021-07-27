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
class BSTIterator {
    List<TreeNode> inOrderList;
    int currentIndex;
    public BSTIterator(TreeNode root) {
        inOrderList = new ArrayList<>();
        inOrder(root);
        this.currentIndex = -1;
    }
    
    public boolean hasNext() {
        if(currentIndex < inOrderList.size() -1 ){
            return true;
        }
        return false;
    }
    
    public int next() {
        currentIndex++;
        return inOrderList.get(currentIndex).val;
        
    }
    
    public boolean hasPrev() {
        if(currentIndex > 0){
            return true;
        }
        return false;
    }
    
    public int prev() {
       
        currentIndex --;
        return inOrderList.get(currentIndex).val;
    }
    
    private void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        
        inOrder(root.left);
        inOrderList.add(root);
        inOrder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * boolean param_1 = obj.hasNext();
 * int param_2 = obj.next();
 * boolean param_3 = obj.hasPrev();
 * int param_4 = obj.prev();
 */