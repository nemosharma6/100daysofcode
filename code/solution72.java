/* https://leetcode.com/problems/palindromic-substrings/ */
class Solution {
    public int countSubstrings(String s) {
        
        boolean dp[][] = new boolean[s.length()][s.length()];
        int ct = s.length();
        
        if(ct == 0 || ct == 1)
            return ct;
        
        for(int i=0;i<s.length();i++)
            dp[i][i] = true;
        
        for(int i=1;i<s.length();i++){
            for(int j=0;j<=s.length();j++){
                
                int k = j+i;
                if(k >= s.length()) break;
                
                if(k-j==1)
                    dp[j][k] = (s.charAt(j) == s.charAt(k));
                else 
                    if(j<s.length()-1 && k>=1)
                        dp[j][k] = (s.charAt(j) == s.charAt(k)) && dp[j+1][k-1];
                
                if(dp[j][k])
                    ct += 1;
            }
        }
        
        return ct;
    }
}
