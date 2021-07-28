/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    Map<ListNode, Integer> positionMap = new HashMap<>();
    
    public ListNode detectCycle(ListNode head) {
        int currentPosition = 0;
        ListNode runner = head;
        while(runner != null) {
            if(positionMap.containsKey(runner)){
                return runner;
            }
            positionMap.put(runner, currentPosition);
            currentPosition++;
            runner = runner.next;
        }
        return null;
    }
}