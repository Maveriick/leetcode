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
        ListNode sol = new ListNode(0);
        sol.next = head;
        
        ListNode rightMostNotNine = sol;
        while(head != null){
            if(head.val != 9){
                rightMostNotNine = head;
            }
            head = head.next;
        }
        
        rightMostNotNine.val = rightMostNotNine.val + 1;
        rightMostNotNine = rightMostNotNine.next;
        while(rightMostNotNine != null){
            rightMostNotNine.val = 0;
            rightMostNotNine = rightMostNotNine.next;
        }
        
        return sol.val != 0 ? sol : sol.next;
    }
}
