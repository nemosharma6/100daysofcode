/**
 https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverse(head,k);
    }
    
    public ListNode reverse(ListNode node, int k){
        ListNode prev=null, next=null, curr=node;
        boolean undo=false;
        for(int i=0;i<k;i++){
            if(curr==null) {
                undo=true;
                break;
            }
            
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        if(undo){
            curr=prev;
            prev=null;
            while(curr!=null){
                next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            
            return prev;
        }
        
        if(next!=null)
            node.next=reverse(next,k);
        
        return prev;
    }
}
