/* https://leetcode.com/problems/minimum-falling-path-sum/ */
class Solution {
    
    Integer[][] dp;
    public int minFallingPathSum(int[][] A) {
        int min=Integer.MAX_VALUE;
        dp=new Integer[A.length][A[0].length];
        for(int i=0;i<A[0].length;i++)
            min=Math.min(min,rec(A,0,i));
        return min;
    }
    
    public int rec(int[][] a, int i, int j){
        if(i==a.length) return 0;
        if(j<0 || j==a[0].length) return Integer.MAX_VALUE;
        if(dp[i][j]!=null) return dp[i][j];
        dp[i][j]=a[i][j]+Math.min(rec(a,i+1,j), Math.min(rec(a,i+1,j+1), rec(a,i+1,j-1)));
        return dp[i][j];
    }
}
