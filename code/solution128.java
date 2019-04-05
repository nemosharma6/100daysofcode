/* https://leetcode.com/problems/palindrome-partitioning-ii/ */
class Solution {
    
    Integer[] sol;
    public int minCut(String s) {
        
        sol=new Integer[s.length()];
        boolean[][] dp=new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
            dp[i][i]=true;
        
        for(int i=1;i<s.length();i++){
            for(int j=0;j<s.length()-i;j++){
                if(s.charAt(j)==s.charAt(j+i) && (i==1 || i==2)){
                    dp[j][j+i]=true;
                    continue;
                }
                
                if(s.charAt(j)==s.charAt(j+i) && dp[j+1][j+i-1])
                    dp[j][j+i]=true;
            }
        }
        
        return rec(dp,0)-1;
    }
    
    public int rec(boolean[][] s, int i){
        
        if(i==s.length)
            return 0;
        
        if(sol[i]!=null)
            return sol[i];
        
        int min=Integer.MAX_VALUE;
        for(int j=i;j<s.length;j++){
            if(s[i][j]) {
                int ret=rec(s,j+1);
                if(ret!=Integer.MAX_VALUE)
                    min=Math.min(min, 1+ret);
            }
        }
        
        sol[i]=min;
        return min;
    }
}
