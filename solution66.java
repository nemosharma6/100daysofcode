/* https://leetcode.com/problems/implement-trie-prefix-tree/ */
class Trie {

    static class Node {
        boolean status;
        Node[] children;
        public Node(){
            status = false;
            children = new Node[26];
        }
    }
    
    Node head;
    
    /** Initialize your data structure here. */
    public Trie() {
        head = new Node();
        head.status = true;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        
        Node tmp = head;
        for(int i=0;i<word.length();i++){
            int ind = word.charAt(i) - 97;
            if(tmp.children[ind] == null)
                tmp.children[ind] = new Node();
                
            tmp = tmp.children[ind];
        }
        
        tmp.status = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        Node tmp = head;
        
        for(int i=0;i<word.length();i++){
            int ind = word.charAt(i) - 97;
            if(tmp.children[ind] == null)
                return false;
            else
                tmp = tmp.children[ind];
        }
        
        return tmp.status;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        Node tmp = head;
        
        for(int i=0;i<prefix.length();i++){
            int ind = prefix.charAt(i) - 97;
            if(tmp.children[ind] == null)
                return false;
            else
                tmp = tmp.children[ind];
        }
        
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
