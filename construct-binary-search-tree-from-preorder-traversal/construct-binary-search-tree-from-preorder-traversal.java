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
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        List<Integer> input = new ArrayList<>();
        for(int i = 0; i < preorder.length; i++) {
            input.add(preorder[i]);
        }
        return buildTree(input);
    }
    
    private TreeNode buildTree(List<Integer> preOrder) {
        if(preOrder.size() == 0) {
            return null;
        }
    
        TreeNode root = new TreeNode(preOrder.get(0));
        int pivot = preOrder.get(0);
        List<Integer> lessThan = new ArrayList<>();
        List<Integer> moreThan = new ArrayList<>();
        for(int i = 1; i < preOrder.size(); i++) {
            if(preOrder.get(i) <= pivot) {
                lessThan.add(preOrder.get(i));
            } else {
                moreThan.add(preOrder.get(i));
            }
        }
        
        root.left = buildTree(lessThan);
        root.right = buildTree(moreThan);
        return root;  
    }
}