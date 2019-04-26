/* https://leetcode.com/problems/stream-of-characters/ */
class StreamChecker {
    
    class Trie {
        boolean end=false;
        Trie[] child=new Trie[26];
    }

    Trie head;
    StringBuilder sb=new StringBuilder();
    public StreamChecker(String[] words) {
        head=new Trie();
        for(String w: words)
            insert(w,head);
    }
    
    public void insert(String w, Trie t){
        for(int i=w.length()-1;i>=0;i--){
            if(t.child[w.charAt(i)-'a']==null)
                t.child[w.charAt(i)-'a']=new Trie();
            t=t.child[w.charAt(i)-'a'];
        }
        t.end=true;
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        Trie node=head;
        for(int i=sb.length()-1;i>=0;i--){
            if(node.child[sb.charAt(i)-'a']==null) return false;
            if(node.child[sb.charAt(i)-'a'].end) return true;
            else node=node.child[sb.charAt(i)-'a'];
        }
        
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
