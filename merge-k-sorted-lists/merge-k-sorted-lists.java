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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode solution = new ListNode(-1);
        ListNode solutionHead = solution;
        
        if(lists.length == 0) {
            return solutionHead.next;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                 pq.add(lists[i]);
            }
           
        }
        
        while(!pq.isEmpty()) {
            ListNode min = pq.poll();
            if(min != null) {
                solution.next = new ListNode(min.val);
                solution = solution.next;
                if(min.next != null) {
                    min = min.next;
                    pq.add(min);
                 }
            }
        }
        
        return solutionHead.next;
    }
}