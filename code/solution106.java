/* https://leetcode.com/problems/word-ladder/ */
class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        boolean present = false;
        for(int i=0;i<wordList.size();i++)
            if(wordList.get(i).equals(endWord)) {
                present = true;
                break;
            }
        
        if(!present)
            return 0;
        
        wordList.add(0, beginWord);
        boolean[][] adj = new boolean[wordList.size()][wordList.size()];
        
        for(int i=0;i<wordList.size();i++)
            for(int j=i+1;j<wordList.size();j++) {
                adj[i][j]=diff(wordList.get(i), wordList.get(j));
                adj[j][i]=adj[i][j];
            }
        
        Queue<String> queue = new LinkedList();
        boolean[] v = new boolean[wordList.size()];
        
        queue.add(0 + "_0");
        v[0]=true;
        
        while(!queue.isEmpty()){
            String s = queue.poll();
            int in = Integer.parseInt(s.split("_")[0]);
            int c = Integer.parseInt(s.split("_")[1]);
            
            if(wordList.get(in).equals(endWord))
                return c+1;
            
            for(int i=0;i<wordList.size();i++){
                if(!v[i] && adj[in][i]){
                    v[i]=true;
                    queue.add(i+"_"+(c+1));
                }
            } 
        }
        
        return 0;
    }
    
    public boolean diff(String a, String b){
        int d=0;
        for(int i=0;i<a.length();i++)
            if(a.charAt(i)!=b.charAt(i))
                d++;
        
        return d==1;
    }
}
