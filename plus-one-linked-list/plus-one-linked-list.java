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
    public ListNode plusOne(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode lastNonNine = head;
        ListNode runner = sentinel;
        while(runner != null) {
            if(runner.val != 9){
                lastNonNine = runner;
            }
            runner = runner.next;
        }
        
        lastNonNine.val = lastNonNine.val + 1;
        lastNonNine = lastNonNine.next;
        while(lastNonNine != null ){
            lastNonNine.val = 0;
            lastNonNine = lastNonNine.next;
        }
        
        if(sentinel.val == 1) {
            return sentinel;
        }
        return sentinel.next;
        
        
        
    }
}