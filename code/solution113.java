/* https://leetcode.com/problems/wildcard-matching/ */
class Solution {
    public boolean isMatch(String s, String p) {
        
        if(p.length()==0 && s.length()==0)
            return true;
        
        if(p.length()==0)
            return false;
        
        // boolean ast[] = new boolean[p.length()];
        // onlyAst(p, ast);
        
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        
        dp[0][0]=true;
        for(int i=1;i<=p.length();i++)
            if(p.charAt(i-1)=='*')
                dp[0][i]=true;
            else
                break;
        
        for(int i=1;i<=s.length();i++)
            dp[i][0]=false;
        
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?')
                    dp[i][j]=dp[i-1][j-1];
                else
                if(p.charAt(j-1)=='*')
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
            }
        }
        
        return dp[s.length()][p.length()];
    }
    
    public boolean rec(String s, String p, int i, int j, boolean[] ast){
        
        if(i==s.length() && j==p.length())
            return true;
        
        if(i==s.length() && ast[j])
            return true;
        
        if(j==p.length())
            return false;
        
        boolean sol = false;
        if(i<s.length() && j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'))
            sol = sol || rec(s,p,i+1,j+1,ast);
        
        if(i<s.length() && j<p.length() && p.charAt(j)=='*'){
            sol = sol || rec(s,p,i,j+1,ast);
            sol = sol || rec(s,p,i+1,j,ast);
        }
        
        return sol;
    }
    
    public void onlyAst(String p, boolean[] ast){
        ast[p.length()-1]=p.charAt(p.length()-1)=='*';
        
        for(int i=p.length()-2;i>=0;i--)
            if(p.charAt(i)=='*')
                ast[i]=true;
            else
                break;
    }
}
