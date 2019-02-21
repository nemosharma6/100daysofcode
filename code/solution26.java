/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    
    Map<Integer, Node> mp = new HashMap();
    
    public Node connect(Node root) {
        if(root == null) return root;
        dfs(root, 0);
        return root;
    }
    
    public void dfs(Node node, int l){
        
        if(node == null) return;
        
        if(mp.containsKey(l)){
            Node n = mp.get(l);
            n.next = node;
            node.next = null;   
        }
        
        mp.put(l, node);
        dfs(node.left, l+1);
        dfs(node.right, l+1);
    }
}
