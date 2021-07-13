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
    public ListNode removeElements(ListNode head, int val) {
        ListNode headPtr = head;
    
        while(head != null && head.val == val) {
            head = head.next;
        }
        
        
        if(head == null) {
            return head;
        }
        
        ListNode runner = head;
        while(runner != null && runner.next != null) {
            if(runner.next.val == val) {
                ListNode next = runner.next;
                while(next != null && next.val == val) {
                    next = next.next;
                }
                runner.next = next;
            }
            runner = runner.next;
        }
        return head;
    }
}