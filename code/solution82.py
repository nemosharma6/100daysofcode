# https://leetcode.com/problems/unique-paths/
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[]
        for i in range(m+1):
            t=[]
            for j in range(n+1):
                t.append(0)
            dp.append(t)
            
        dp[0][0]=0
        dp[1][0]=1
        dp[1][1]=1
        for i in range(1,m+1):
            for j in range(1,n+1):
                dp[i][j]=dp[i-1][j]+dp[i][j-1]
                
        return dp[m][n]
