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
            Node tmp= new Node(insertVal, null);
            tmp.next= tmp;
            return tmp;
        }
        
        Node prev= head;
        Node curr= head.next;
        
        while(curr != head) {
            if(prev.val <= insertVal && curr.val >= insertVal) {
                break;
            }
            if(prev.val > curr.val) {
                if(insertVal >= prev.val || insertVal <= curr.val) {
                    break;
                }
            }
            prev= prev.next;
            curr= curr.next;
        }
        
        Node tmp= new Node(insertVal, prev.next);
        prev.next= tmp;
        return head;
        
    }
}