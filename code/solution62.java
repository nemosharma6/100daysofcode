/* https://leetcode.com/problems/edit-distance/ */
class Solution {
    public int minDistance(String word1, String word2) {
        
        if(word1.equals(word2))
            return 0;
        
        if(word1.length() == 0)
            return word2.length();
        
        if(word2.length() == 0)
            return word1.length();
        
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        dp[0][0] = 0;
        
        for(int i=0;i<=word1.length();i++)
            dp[i][0] = i;
        
        for(int i=0;i<=word2.length();i++)
            dp[0][i] = i;
        
        for(int i=1;i<=word1.length();i++) {
            for(int j=1;j<=word2.length();j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
            }
        }
        
        return dp[word1.length()][word2.length()];
    }
    
    public int recursive(String a, String b, int i, int j){
        
        if(i == a.length() && j == b.length())
            return 0;
        
        if(j == b.length())
            return a.length()-i;
        
        if(i == a.length())
            return Integer.MAX_VALUE;
        
        if(a.charAt(i) == b.charAt(j))
            return recursive(a, b, i+1, j+1);
        else {
            int v1 = recursive(a, b, i+1, j);
            int v2 = recursive(a, b, i+1, j+1);
            int v3 = recursive(a, b, i, j+1);
            int mn = Math.min(v1, Math.min(v2, v3));
            if(mn == Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            
            return 1+mn;
        }
    }
}
