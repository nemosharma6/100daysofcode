/* https://leetcode.com/problems/interleaving-string/ */
class Solution {
    
    Boolean[][][] dp; 
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
            return false;
        
        dp=new Boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        return rec(s1,s2,s3,0,0,0);
    }
    
    public boolean rec(String a, String b, String c, int i, int j, int k) {
        
        if(i==a.length() && j==b.length() && k==c.length())
            return true;
        
        if(dp[i][j][k]!=null)
            return dp[i][j][k];
        
        boolean status=false;
        if(i<a.length() && a.charAt(i)==c.charAt(k))
            status=status||rec(a,b,c,i+1,j,k+1);
        
        if(j<b.length() && b.charAt(j)==c.charAt(k))
            status=status||rec(a,b,c,i,j+1,k+1);
        
        dp[i][j][k]=status;
        return status;   
    }
}
