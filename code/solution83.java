/*
https://leetcode.com/problems/clone-graph/
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        return create(node, new HashSet(), new HashMap());
    }
    
    public Node create(Node node, Set<Node> set, Map<Node, Node> map){
        
        if(set.contains(node))
            return map.get(node);
        
        set.add(node);
        List<Node> neigh = new ArrayList();
        Node newNode = new Node(node.val, neigh);
        map.put(node, newNode);
        for(int i=0;i<node.neighbors.size();i++){
            Node tmp = create(node.neighbors.get(i), set, map);
            neigh.add(tmp);
        }
    
        newNode.neighbors = neigh;
        return newNode;
    }
}
