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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode moreHead = more;
        ListNode lessHead = less;
        
        ListNode runner = head;
        while(runner != null) {
            if(runner.val < x) {
                less.next = new ListNode(runner.val);
                less = less.next;
            } else {
                more.next = new ListNode(runner.val);
                more = more.next;
            }
            runner = runner.next;
        }
        
        less.next = moreHead.next;
        return lessHead.next;
        
    
    }
}