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
    int index = 0;
    public TreeNode str2tree(String s) {
        if(s == null || s.equals("")) return null;
        return buildRecursive(s);
    }
    
    private TreeNode buildRecursive(String s){
        int num = getNum(s);
        TreeNode root = new TreeNode(num);
        if(index < s.length() && s.charAt(index) == '(') {
            index ++;
            root.left = buildRecursive(s);
            if(index < s.length() && s.charAt(index) == '(') {
                index ++;
                root.right = buildRecursive(s);
            }
        }
        index++;
        return root;
    }
    
    
    
    public int getNum(String s){
        
        boolean isNegative = false;
        if(s.charAt(index) == '-'){
            isNegative = true;
            index++;
        }
        
        int num = 0;
        while(index < s.length() && Character.isDigit(s.charAt(index))){
            num = num * 10 + Integer.parseInt(String.valueOf(s.charAt(index)));
            index++;
        }
        
        return isNegative ? num * -1 : num;
    }
}