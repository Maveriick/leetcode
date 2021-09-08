/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    List<Integer> sorted = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        ListNode runner = head;
        while(runner != null) {
            sorted.add(runner.val);
            runner = runner.next;
        }
        
        return buildTree(sorted, 0, sorted.size() - 1);
    }
    
    
    private TreeNode buildTree(List<Integer> arrayList, int left, int right) {
        if(left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        int value = sorted.get(mid);
        TreeNode root = new TreeNode(value);
        root.left = buildTree(arrayList, left, mid - 1);
        root.right = buildTree(arrayList, mid + 1, right);
        return root;
    }
}