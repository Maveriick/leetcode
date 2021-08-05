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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode solutionHead = head;
        ListNode oddIndex = head;
        ListNode evenIndex = head.next;
        ListNode evenHead = evenIndex;
        
        while(oddIndex != null  && evenIndex != null && evenIndex.next != null) {
            oddIndex.next = evenIndex.next;
            oddIndex = oddIndex.next;
            if(oddIndex != null) {
                evenIndex.next = oddIndex.next;
            }
            
            if(evenIndex != null) {
                 evenIndex = evenIndex.next;
            }
        }
        
        oddIndex.next = evenHead;
        return solutionHead;
    }
}