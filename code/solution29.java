/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/ */

class Solution {
    public int maxProfit(int[] prices) {        
        
        if(prices.length == 0) return 0;
        
        int dp[] = new int[prices.length];
        dp[0] = 0;
        
        int mx=0;
        
        for(int i=1;i<prices.length;i++){
            for(int j=0;j<i;j++) {
                if(j==0 || j==1) {
                    if(prices[i]>=prices[j]) 
                        dp[i] = max(dp[i], prices[i]-prices[j]);
                } else if(prices[i]>prices[j] && j>=2)
                        dp[i] = max(dp[i], prices[i]-prices[j]+dp[j-2]);
                }
            
            mx = max(dp[i], mx);
            dp[i] = mx;
        }
        
        return dp[prices.length-1];
        
    }
    
    public int max(int a, int b){
        if(a>b) return a; else return b;
    }
}