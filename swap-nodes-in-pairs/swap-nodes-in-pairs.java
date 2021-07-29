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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode current = head;
        ListNode next = null;
        ListNode prev = dummy;
        
        while(current != null && current.next != null) {
            next = current.next;
            
            prev.next = next;
            current.next = next.next;
            next.next = current;
            
            
            prev = current;
            current = current.next;
            
    
        }
        return dummy.next;
    }
}