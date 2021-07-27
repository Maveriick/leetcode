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
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        
        ListNode left = head;
        int leftCount = 0;
        while(leftCount < k - 1){
            leftCount++;
            left = left.next;
        }
        
        ListNode middle = head;
        ListNode right = head;
        int rightCount = 0;
        while(rightCount < k - 1){
            rightCount++;
            right = right.next;
        }
        
        while(right.next != null) {
            middle = middle.next;
            right = right.next;
        }
       
        int temp = left.val;
        left.val = middle.val;
        middle.val = temp;
        
        return head;
    }
}