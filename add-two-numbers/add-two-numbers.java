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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Head = l1;
        ListNode l2Head = l2;
        ListNode solution = new ListNode(0);
        ListNode solPtr = solution;
        
        int carry = 0;
        while(l2Head != null && l1Head != null) {
            int sum = l1Head.val + l2Head.val + carry;
            if(sum > 9) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            
            solution.next = new ListNode(sum);
            solution = solution.next;
            l1Head = l1Head.next;
            l2Head = l2Head.next;
            
        }
        
        if(l1Head == null){
            while(l2Head != null) {
                int sum = l2Head.val + carry;
                if(sum > 9) {
                    sum = sum - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                solution.next = new ListNode(sum);
                solution = solution.next;
                l2Head = l2Head.next;
            }
        } else {
            while(l1Head != null) {
                int sum = l1Head.val + carry;
                if(sum > 9) {
                    sum = sum - 10;
                    carry = 1;
                } else {
                    carry = 0;
                }
                solution.next = new ListNode(sum);
                solution = solution.next;
                l1Head = l1Head.next;
            }
        }
        
        if(carry == 1){
            solution.next = new ListNode(carry);
           solution = solution.next;
        }
        return solPtr.next;
    }
}