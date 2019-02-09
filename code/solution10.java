// https://leetcode.com/problems/lru-cache/
// TO-DO - Remove Node from deque without having to parse the deque. Implement on deque.
 
class LRUCache {
    
    class Node {
        int key, value;
        public Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
    
    Map<Integer, Node> map;
    Deque<Node> deque;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>();
        deque = new LinkedList();
        cap = capacity;
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)){
            Node ar[] = new Node[cap];
            int ct = 0;
            
            while(true) {
                Node temp = deque.peekFirst();
                if(temp.key == key) break;
                ar[ct] = temp;
                deque.removeFirst();
                ct++;
            }
            
            deque.removeFirst();
            for(int i=ct-1;i>=0;i--)
                deque.addFirst(ar[i]);
            
            deque.addFirst(map.get(key));
            return map.get(key).value;
        } else
            return -1;
    }
    
    public void put(int key, int value) {
        
        if(!map.containsKey(key)){
            
            if(map.size() == cap){
                Node last = deque.peekLast();
                map.remove(last.key);
                deque.removeLast();
            }
            
            Node t = new Node(key, value);
            map.put(key, t);
            deque.addFirst(t);
        } else {
            Node ar[] = new Node[cap];
            int ct = 0;
            
            while(true) {
                Node temp = deque.peekFirst();
                if(temp.key == key) break;
                ar[ct] = temp;
                deque.removeFirst();
                ct++;
            }
            
            deque.removeFirst();
            for(int i=ct-1;i>=0;i--)
                deque.addFirst(ar[i]);
            
            Node t = new Node(key, value);
            map.put(key, t);
            deque.addFirst(t);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
