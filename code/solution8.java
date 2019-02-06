// https://leetcode.com/problems/word-search-ii/

class Solution {
    
    class Index {
        int x, y;
        public Index(int a, int b){
            x = a;
            y = b;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        boolean firstChar[] = new boolean[26];
        for(int i=0;i<words.length;i++){
            firstChar[words[i].charAt(0)-'a'] = true;
        }
        
        ArrayList<ArrayList<Index>> ar = new ArrayList<ArrayList<Index>>();
        for(int i=0;i<26;i++) ar.add(new ArrayList<Index>());
        
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                if(firstChar[board[i][j] - 'a'])
                    ar.get(board[i][j] - 'a').add(new Index(i, j));
        
        Set<String> sol = new HashSet<String>();
        
        
        for(int i=0;i<words.length;i++){    
            boolean vis[][] = new boolean[board.length][board[0].length];
            vis[0][0] = false;
            
            for(int j=0;j<ar.get(words[i].charAt(0) - 'a').size();j++){
                Index ind = ar.get(words[i].charAt(0) - 'a').get(j);
                boolean chk = check(ind.x, ind.y, vis, words[i], board, 0);
                if(chk){
                    sol.add(words[i]);
                    break;
                }
            }
        }
        
        return new ArrayList<String>(sol);
        
    }
    
    boolean check(int i, int j, boolean vis[][], String word, char[][] ar, int l){
        
        if(word.charAt(l) == ar[i][j] && !vis[i][j]){
            
            if(l+1 == word.length()) return true;
            
            vis[i][j] = true;
            boolean chk = false;
            
            if(i<ar.length-1) {
                chk = check(i+1, j, vis, word, ar, l+1);
                if(chk) return chk;
            }
            
            if(j<ar[0].length-1) {
                chk = check(i, j+1, vis, word, ar, l+1);
                if(chk) return chk;
            }
            
            if(i>0) {
                chk = check(i-1, j, vis, word, ar, l+1);
                if(chk) return chk;
            }
            
            if(j>0) {
                chk = check(i, j-1, vis, word, ar, l+1);
                if(chk) return chk;
            }
            
            vis[i][j] = false;
        }
        
        return false;
        
    }
}