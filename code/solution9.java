// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        helper(head);
        return head;
    }
    
    public Node helper(Node node){
        
        Node prev, next;
        prev = null;
        
        while(node != null){
            node.prev = prev;
            prev = node;
            next = node.next;
            
            if(node.child == null) node = next;
            else {
                Node temp = helper(node.child);
        
                node.next = node.child;
                node.child.prev = node;
                
                prev = temp;
                temp.next = next;
                if(next != null)
                    next.prev = temp;
                node.child = null;
                node = next;
            }
        }
        
        return prev;
    }
}
