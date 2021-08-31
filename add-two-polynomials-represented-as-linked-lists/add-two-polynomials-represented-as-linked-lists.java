/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode l1Head = poly1;
        PolyNode l2Head = poly2;
        PolyNode solution = new PolyNode(0, 0);
        PolyNode solPtr = solution;
        
        while(l2Head != null && l2Head.power != 0 && l1Head != null && l1Head.power != 0) {
            if(l1Head.power > l2Head.power){
               
                if(l1Head.coefficient != 0 ){
                    solution.next = new PolyNode(l1Head.coefficient, l1Head.power);
                    solution = solution.next;
                }
              
                l1Head = l1Head.next;
            } else if(l2Head.power > l1Head.power) {
               
                if(l2Head.coefficient != 0 ){
                    solution.next = new PolyNode(l2Head.coefficient, l2Head.power);
                    solution = solution.next;
                }
                
                l2Head = l2Head.next;
            } else {
                int sum =  l2Head.coefficient + l1Head.coefficient;
                if(sum != 0 ){
                    solution.next = new PolyNode(sum, l2Head.power);
                    solution = solution.next;
                }
               
                 l1Head = l1Head.next;
                 l2Head = l2Head.next;
            }
        }
        
        if(l1Head == null || l1Head.power == 0){
          
            while(l2Head != null && l2Head.power != 0) {
             
                 
                if(l2Head.coefficient != 0 ){
                    solution.next = new PolyNode(l2Head.coefficient, l2Head.power);
                    solution = solution.next;
                }
                
                l2Head = l2Head.next;
            }
        } else {
            while(l1Head != null && l1Head.power != 0) {
                int sum = l1Head.coefficient;
                if(l1Head.coefficient != 0 ){
                    solution.next = new PolyNode(l1Head.coefficient, l1Head.power);
                    solution = solution.next;
                }
                
                l1Head = l1Head.next;
            }
        }
        
        if(l1Head == null && l2Head == null) {
            return solPtr.next;
        } else if(l1Head != null && l2Head != null) {
            int sum = l1Head.coefficient + l2Head.coefficient;
            if(sum != 0){
                 solution.next = new PolyNode(sum, 0);
            solution = solution.next;
            }
           
        } else {
            if(l1Head == null) {
                if(l2Head.coefficient != 0 ){
                    solution.next = new PolyNode(l2Head.coefficient, l2Head.power);
                    solution = solution.next;
                }
              
            } else {
                if(l1Head.coefficient != 0 ){
                    solution.next = new PolyNode(l1Head.coefficient, l1Head.power);
                    solution = solution.next;
                }
            }
        }
       
        
        return solPtr.next;
    }
}