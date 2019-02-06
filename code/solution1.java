// https://leetcode.com/problems/odd-even-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode oddHead, evenHead, pOdd, pEven, cOdd, cEven, fOdd, fEven;
        oddHead = cOdd = head;
        evenHead = cEven = head.next;
        pOdd = pEven = null;
        
        while(true){
            
            if(pOdd != null) pOdd.next = cOdd;
            if(pEven != null) pEven.next = cEven;
            
            fOdd = cEven.next;
            
            if(fOdd == null) {
                cOdd.next = evenHead;
                cEven.next = null;
                break;
            }
            
            fEven = fOdd.next;
            
            if(fEven == null){
                cOdd.next = fOdd;
                cOdd = fOdd;
                cOdd.next = evenHead;
                cEven.next = null;
                break;
            }
            
            pOdd = cOdd;
            pEven = cEven;
            
            cOdd = fOdd;
            cEven = fEven; 
            
        }
        
        return oddHead;
        
    }
}
