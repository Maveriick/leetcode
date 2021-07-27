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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return head;
        }
        
        if(head.next == null && n == 1){
            return null;
        }
        ListNode toRemove = head;
        for(int i= 0; i < n; i++){
            toRemove = toRemove.next;
        }
        
        ListNode prev = null;
        ListNode ptr = head;
        
        while(toRemove != null){
            prev = ptr;
            ptr = ptr.next;
            toRemove = toRemove.next;
        }
        System.out.println(ptr.val);
        
        if(prev != null) {
            prev.next = ptr.next;
        } else {
            head = head.next;
        }
        
        
    
        return head;
    }
}