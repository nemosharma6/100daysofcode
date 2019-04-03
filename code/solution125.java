/* https://leetcode.com/problems/distinct-subsequences/ */
class Solution {
    
    // Integer[][] dp;
    public int numDistinct(String s, String t) {
        
        // dp=new Integer[s.length()+1][t.length()+1];
        int[][] d=new int[s.length()+1][t.length()+1];
        
        for(int i=0;i<=s.length();i++)
            d[i][0]=1;
        
        for(int i=1;i<=s.length();i++)
            for(int j=1;j<=t.length();j++){
                d[i][j]=d[i-1][j];
                if(s.charAt(i-1)==t.charAt(j-1))
                    d[i][j]+=d[i-1][j-1];
            }
        
        return d[s.length()][t.length()];
        // return rec(s,t,0,0);
    }
    
//     public int rec(String s, String t, int i, int j){
        
//         if(i==s.length() && j==t.length())
//             return 1;
        
//         if(i==s.length())
//             return 0;
        
//         if(dp[i][j]!=null)
//             return dp[i][j];
        
//         int c=0;
//         if(i<s.length() && j<t.length() && s.charAt(i)==t.charAt(j))
//             c+=rec(s,t,i+1,j+1);
        
//         c+=rec(s,t,i+1,j);
//         dp[i][j]=c;
//         return c;
//     }
}
