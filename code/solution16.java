/*
 * https://leetcode.com/problems/merge-two-sorted-lists/

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode newList = null;
        ListNode prev = null;
        
        while(l1 != null && l2 != null){
            ListNode node = null;
            if(l1.val < l2.val){
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            
            if(newList == null)
                newList = node;
            else
                prev.next = node;
                
            prev = node;
        }
        
        if(l1 == null){
            while(l2 != null){
                if(prev != null) prev.next = l2;
                prev = l2;
                if(newList == null) newList = prev;
                l2 = l2.next;
            }
        }
        
        if (l2 == null){
            while(l1 != null){
                if(prev != null) prev.next = l1;
                prev = l1;
                if(newList == null) newList = prev;
                l1 = l1.next;
            }
        }
        
        if (prev != null) prev.next = null;
        return newList;
        
    }
}
