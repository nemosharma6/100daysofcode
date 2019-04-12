/**
 https://leetcode.com/problems/swap-nodes-in-pairs/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        return rec(head);
    }
    
    public ListNode rec(ListNode head){
        if(head==null) return null;
        ListNode node=head, next=head.next;
        if(next==null) return head;
        ListNode last=null;
        if(next!=null) last=next.next;
        next.next=node;
        node.next=rec(last);
        return next;
    }
}
