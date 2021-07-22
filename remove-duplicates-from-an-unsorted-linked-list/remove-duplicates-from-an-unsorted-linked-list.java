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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
       
        Map<Integer, Integer> fMap = new HashMap<>();
        
        ListNode pussy = head;
        while(pussy != null){
            int current = fMap.getOrDefault(pussy.val, 0);
            fMap.put(pussy.val, ++current);
            pussy = pussy.next;
        }
        
       
        ListNode runner = head;
        while(runner != null && fMap.get(runner.val) > 1){
            runner = runner.next;
        }
        
        if(runner == null) {
            return null;
        }
        
        System.out.println(runner.val);
        ListNode solPtr = runner;
        while(runner.next != null){
            if(fMap.get(runner.next.val) > 1){
                runner.next = runner.next.next;
            } else {
                runner = runner.next;
            }
        }
      
        
        return solPtr;
    }
}