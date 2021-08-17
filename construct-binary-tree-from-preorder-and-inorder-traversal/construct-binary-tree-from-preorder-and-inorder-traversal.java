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
    Map<Integer, Integer> indexMap = new HashMap<>();
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            indexMap.put(inorder[i], i);
        }
        
        return buildTree(preorder, inorder, 0, inorder.length - 1);
        
    }
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {
        if(start > end) {
            return null;
        }
        
        int value = preorder[index];
        int currentIndex = indexMap.get(value);
        index++;
        TreeNode n = new TreeNode(value);
        n.left = buildTree(preorder, inorder, start, currentIndex - 1);
        n.right = buildTree(preorder, inorder, currentIndex + 1, end);
        return n;
        
        
    }
}