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
    public void reorderList(ListNode head) {
        ListNode runner = head;
        
        
        Stack<ListNode> s = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPtr;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slowPtr = slow;
        while(slow != null){
            s.push(slow);
            slow = slow.next;
        }
        
        //System.out.println(s.toString());
        
        ListNode start = head;
        ListNode next = null;
        ListNode popped = null;
        while(start != slowPtr){
            next = start.next;
            popped = s.pop();
            start.next = popped;
            popped.next = next;
            start = next;
        }
        
        if(!s.isEmpty()) {
            ListNode last = s.pop();
            System.out.println(last.val);
            start.next = last;
            last.next = null;
        } else{
             popped.next = null;
        }
       
        
    }
}