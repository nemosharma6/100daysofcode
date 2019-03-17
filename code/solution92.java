/**
 https://leetcode.com/problems/merge-k-sorted-lists/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode head = null;
        ListNode sol = null;
        
        while(true){
            
            int val = Integer.MAX_VALUE; 
            ListNode min = null;
            int ind = -1;
            
            for(int i=0;i<lists.length;i++){
                if(lists[i] != null && val > lists[i].val){
                    val = lists[i].val;
                    min = lists[i];
                    ind = i;
                }
            }
            
            if(min == null)
                break;
            
            if(head == null)
                head = min;
            
            if(sol != null)
                sol.next = min;
            
            sol = min;
            lists[ind] = lists[ind].next;
        }
        
        if(sol == null)
            return null;
        
        sol.next = null;
        return head;
        
    }
}
