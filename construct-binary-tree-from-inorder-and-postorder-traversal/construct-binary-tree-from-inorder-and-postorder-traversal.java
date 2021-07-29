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
    int currentIndex;
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        currentIndex = postorder.length - 1;
        for(int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        
        return buildTree(inorder, postorder, indexMap, 0, postorder.length - 1);
    }
    
    
    private TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer, Integer> indexMap, int left, int right) {
        if(left > right){
            return null;
        }
        
        int currentElement = postorder[currentIndex];
        currentIndex--;
        int currentElementIndex = indexMap.get(currentElement);
        TreeNode root = new TreeNode(currentElement);
        root.right = buildTree(inorder, postorder, indexMap, currentElementIndex + 1, right);
        root.left = buildTree(inorder, postorder, indexMap, left, currentElementIndex - 1);
        return root;
    }
}