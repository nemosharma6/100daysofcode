/* https://leetcode.com/problems/longest-increasing-path-in-a-matrix/ */
class Solution {
    
    public int longestIncreasingPath(int[][] matrix) {
        
        int mx=1;
        int r,c;
        r = matrix.length;
        if(r==0) 
            return 0;
        
        c = matrix[0].length;
        if(c==0) 
            return 0;
        
        int dp[][] = new int[r][c];
        
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) dp[i][j]=-1;
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++) {
                int t = rec1(matrix, i, j, dp, r, c);
                mx = Math.max(t, mx);
            }      
        
        for(int i=0;i<r;i++) for(int j=0;j<c;j++) dp[i][j]=-1;
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++) {
                int t = rec2(matrix, i, j, dp, r, c);
                mx = Math.max(t, mx);
            }
        
        return mx;
    }
    
    public int rec1(int[][] m, int i, int j, int[][] dp, int r, int c){
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int t=1;
        
        if(i==r || j==c)
            return 0;
        
        if(i<r-1 && m[i][j] > m[i+1][j])
            t = Math.max(t, 1+rec1(m, i+1, j, dp, r, c));
        
        if(j<c-1 && m[i][j] > m[i][j+1])
            t = Math.max(t, 1+rec1(m, i, j+1, dp, r, c));
        
        if(i>0 && m[i][j] > m[i-1][j])
            t = Math.max(t, 1+rec1(m, i-1, j, dp, r, c));
        
        if(j>0 && m[i][j] > m[i][j-1])
            t = Math.max(t, 1+rec1(m, i, j-1, dp, r, c));
        
        dp[i][j] = t;
        return t;
    }
    
    public int rec2(int[][] m, int i, int j, int[][] dp, int r, int c){
        
        if(i==r || j==c)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int t=1;
        
        if(i<r-1 && m[i][j] < m[i+1][j])
            t = Math.max(t, 1+rec2(m, i+1, j, dp, r, c));
        
        if(j<c-1 && m[i][j] < m[i][j+1])
            t = Math.max(t, 1+rec2(m, i, j+1, dp, r, c));
        
        if(i>0 && m[i][j] < m[i-1][j])
            t = Math.max(t, 1+rec2(m, i-1, j, dp, r, c));
        
        if(j>0 && m[i][j] < m[i][j-1])
            t = Math.max(t, 1+rec2(m, i, j-1, dp, r, c));
        
        dp[i][j]=t;
        return t;
    }
}
