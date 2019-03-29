/* https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/ */
class Solution {
    
    int ct;
    public int removeStones(int[][] stones) {
        
        if(stones.length==0 || stones.length==1)
            return 0;
        
        boolean[] v = new boolean[stones.length];
        
        int mx=0;
        for(int i=0;i<stones.length;i++){
            if(!v[i]){
                ct=0;
                v[i]=true;
                dfs(stones,i,v);
                mx+=ct;
            }
        }
        
        return mx;
    }
    
    public void dfs(int[][] s, int k, boolean[] v){
        
        for(int i=0;i<s.length;i++){
            if(!v[i] && (s[i][0]==s[k][0] || s[i][1]==s[k][1])){
                v[i]=true;
                ct++;
                dfs(s,i,v);
            }
        }
    }
}
