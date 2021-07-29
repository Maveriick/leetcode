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
    Map<Integer, Integer> indexMap;
    int currentIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        
        return build(preorder, indexMap, 0, preorder.length - 1);
    }
    
    private TreeNode build(int[] preorder , Map<Integer, Integer> indexMap, int left, int right) {
       if(left > right) {
           return null;
       }
        
        int currentVal = preorder[currentIndex];
        currentIndex++;
        int currentElementIndex = indexMap.get(currentVal);
        TreeNode root = new TreeNode(currentVal);
        root.left = build(preorder, indexMap, left, currentElementIndex - 1);
        root.right = build(preorder, indexMap, currentElementIndex + 1, right);
        return root;
       
    }
    
    
}