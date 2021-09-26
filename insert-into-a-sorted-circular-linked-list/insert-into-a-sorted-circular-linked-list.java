/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        
        
        if(head == null) {
            head = new Node(insertVal);
            head.next = head;
            return head;
        }
        
        Node prev = head;
        Node current = head.next;
        
        while(prev.next != head) {
            if(prev.val <= insertVal && insertVal <= current.val) {
                break;
            }
            
            if(prev.val > current.val) {
                if(insertVal > prev.val || insertVal < current.val){
                    break;
                }
            }
            
            prev = prev.next;
            current = current.next;
        }
        
        Node newNode = new Node(insertVal);
        newNode.next = prev.next;
        prev.next = newNode;
        return head;
        
    }
}