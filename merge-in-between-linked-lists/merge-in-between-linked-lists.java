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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l1RunnerStart = list1;
        int count = 0;
        while(l1RunnerStart != null && count < a -1 ){
            l1RunnerStart = l1RunnerStart.next;
            count++;
        }
        
        int count2 = 0;
        ListNode l2RunnerStart = list1;
        while(l2RunnerStart != null && count2 < b){
            l2RunnerStart = l2RunnerStart.next;
            count2++;
        }
        
        
        ListNode l2End = list2;
        while(l2End.next != null) {
            l2End = l2End.next;
        }
        
        l1RunnerStart.next = list2;
        l2End.next = l2RunnerStart.next;
        return list1;
        
    }
}