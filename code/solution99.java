/* https://leetcode.com/problems/ugly-number-ii/ */
class Solution {
    public int nthUglyNumber(int n) {
        
        if(n==0)
            return 0;
        
        int[] dp = new int[n];
        int num2=2, num3=3, num5=5;
        int ind2=1, ind3=1, ind5=1;
        dp[0]=1;
        
        for(int i=1;i<n;i++){
            int num = Math.min(num2, Math.min(num3, num5));
            dp[i]=num;
            if(num==num2)
                num2=dp[ind2++]*2;
            if(num==num3)
                num3=dp[ind3++]*3;
            if(num==num5)
                num5=dp[ind5++]*5;
        }
        
        return dp[n-1];
    }
}
