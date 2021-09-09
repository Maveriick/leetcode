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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        
        ListNode leftHead = sentinel;
        ListNode rightHead = sentinel;
        int leftCounter = 0;
        while(leftCounter < left - 1) {

            leftHead = leftHead.next;
            leftCounter ++;
        }
        
        System.out.println(leftHead.val);
        
        int rightCounter = 0;
        while(rightCounter  < right) {
            rightHead = rightHead.next;
            rightCounter++;
        }
        
        if(leftHead == rightHead) {
            return head;
        }
        //System.out.println(rightHead.val);
        //System.out.println();
        
        ListNode afterNext = rightHead.next;
        ListNode toReverse = leftHead.next;
        rightHead.next = null;
        
        ListNode reversed = reverse(toReverse);
        ListNode reverseRunner = reversed;
        while(reverseRunner.next != null) {
            //System.out.println(reverseRunner.val);
            reverseRunner = reverseRunner.next;
        }
        leftHead.next = reversed;
       
        
        reverseRunner.next = afterNext;
        return sentinel.next;
        
        
    }
    
    
    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode next = null;
        
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}