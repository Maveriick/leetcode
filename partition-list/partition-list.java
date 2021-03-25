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
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        Queue<ListNode> less = new LinkedList<>();
        Queue<ListNode> more = new LinkedList<>();
        ListNode runner = head;
        while(runner != null) {
            if(runner.val < x){
                less.add(runner);
                
            } else if(runner.val >= x){
                more.add(runner);
            }
            runner = runner.next;
        }
        
       
        ListNode sol = new ListNode(-1);
        ListNode solHead = sol;
        while(!less.isEmpty()){
            sol.next = (less.remove());
            sol = sol.next;
        }
        
        while(!more.isEmpty()){
            sol.next = (more.remove());
            sol = sol.next;
        }
        sol.next = null;
        
        return solHead.next;
        
        
    }
}