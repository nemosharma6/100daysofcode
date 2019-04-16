/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/ */
class Solution {
    public int maxProfit(int[] prices) {
        
        int buy1=Integer.MAX_VALUE,buysell1=0,buy2=Integer.MAX_VALUE,buysell2=0;
        for(int i=0;i<prices.length;i++){
            buy1=Math.min(buy1,prices[i]);
            buysell1=Math.max(buysell1,prices[i]-buy1);
            buy2=Math.min(buy2,prices[i]-buysell1);
            buysell2=Math.max(buysell2,prices[i]-buy2);
        }
        
        return buysell2;
    }
}
