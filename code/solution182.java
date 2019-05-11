/* https://leetcode.com/problems/minimum-score-triangulation-of-polygon/ */
class Solution {
    int dp[][]=new int[50][50];
    public int minScoreTriangulation(int[] A) {
        return rec(A,0,A.length-1);
    }
    
    public int rec(int[] a, int i, int j){
        if(j-i<=1) return 0;
        int sol=Integer.MAX_VALUE;
        if(dp[i][j]!=0) return dp[i][j];
        for(int k=i+1;k<j;k++){
            int s1=rec(a,i,k);
            int s2=rec(a,k,j);
            if(s1==Integer.MAX_VALUE || s2==Integer.MAX_VALUE) continue;
            sol=Math.min(sol,s1+a[i]*a[j]*a[k]+s2);
        }
        if(sol==Integer.MAX_VALUE) return sol;
        dp[i][j]=sol;
        return sol;
    }
}
