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
        
        
        
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode current = head;
        ListNode previous = sentinel;
        ListNode next = null;
        
        
        while(current != null && current.next != null) {
            next = current.next;
            previous.next = next;
            current.next = next.next;
            next.next = current;
            
            
            previous = current;
            current = current.next;
        }
        
        return sentinel.next;
    }
}