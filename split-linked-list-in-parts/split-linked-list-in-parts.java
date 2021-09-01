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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int[] partSizes = new int[k];
        ListNode[] solution = new ListNode[k];
        if(head == null) {
            return solution;
        }
        int totalNodes = 0;
        ListNode runner = head;
        while(runner != null) {
            totalNodes++;
            runner = runner.next;
        }
        
        int remainder = totalNodes % k;
        int partsPerNode = (totalNodes - remainder) / k;
        for(int i = 0; i < k; i++) {
            partSizes[i] = partsPerNode;
        }
        
        for(int i = 0; i < remainder; i++) {
            partSizes[i] = partSizes[i] + 1;
        }
        
        
        ListNode start = head;
        ListNode previous = head;
        ListNode current = head;
        for(int i = 0; i < partSizes.length; i++) {
            int currentPartSize = partSizes[i];
            for(int j = 0; j < currentPartSize; j++) {
                previous = current;
                current = current.next;
            }
            previous.next = null;
            solution[i] = start;
            start = current;
        }
        
        return solution;
    }
}