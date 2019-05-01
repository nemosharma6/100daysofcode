/*  */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode node=head, curr=null, h=null;
        int prev=0;
        boolean first=true;
        while(node!=null){
            int cur=node.val;
            if(node.next==null) {
                if(first) return h;
                if(curr!=null){
                    curr.next=node;
                    curr=node;
                }
                break;
            }
            int nxt=node.next.val;
            if(cur==nxt)
                while(node!=null && node.val==cur) node=node.next;
            else {
                if(first) {
                    h=node;
                    curr=h;
                    first=false;
                } else {
                    curr.next=node;
                    curr=node;
                }
                node=node.next;
            }
        }
        if(head.next!=null && first) return null;
        if(first) return head;
        curr.next=null;
        return h;
    }
}
