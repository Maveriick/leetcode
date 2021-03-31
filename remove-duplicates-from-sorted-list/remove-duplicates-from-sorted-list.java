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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode next = null;
        while(current != null && current.next != null){
            next = current.next;
            if(next.val == current.val){
                while(next != null && next.val == current.val){
                    next = next.next;
                }
                current.next = next;
            }
            
            current = current.next;
        }
        return head;
    }
}