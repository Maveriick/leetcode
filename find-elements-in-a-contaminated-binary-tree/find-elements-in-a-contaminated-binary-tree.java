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
class FindElements {

    List<Integer> allElements;
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root = root;
        this.allElements = new ArrayList<>();
        root.val = 0;
        recover(root);
    }
    
    public boolean find(int target) {
        return allElements.contains(target);
    }
    
    private void recover(TreeNode root) {
        if(root == null) {
            return;
        }
        allElements.add(root.val);
        
        if(root.left != null) {
            root.left.val = (2 * root.val) + 1;
            recover(root.left);
        }
        
        if(root.right != null) {
            root.right.val = (2 * root.val) + 2;
            recover(root.right);
        }
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */