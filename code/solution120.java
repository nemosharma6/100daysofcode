/* https://leetcode.com/problems/minimum-cost-for-tickets/ */
class Solution {
    
    int dp[];
    public int mincostTickets(int[] days, int[] costs) {
        dp=new int[days.length];
        return cheapest(days, costs, 0);
    }
    
    public int cheapest(int[] d, int[] c, int i){
        
        if(i==d.length)
            return 0;
        
        if(dp[i]!=0)
            return dp[i];
        
        int c1=c[0]+cheapest(d,c,i+1);
    
        int st=d[i], j=i;
        while(j<d.length && st+7>d[j]) j++;
        int c2=Integer.MAX_VALUE;
        if(j>i) c2=c[1]+cheapest(d,c,j);
        
        j=i;
        while(j<d.length && st+30>d[j]) j++;
        int c3=Integer.MAX_VALUE;
        if(j>i) c3=c[2]+cheapest(d,c,j);
        
        dp[i]=Math.min(c1,Math.min(c2,c3));
        return Math.min(c1,Math.min(c2,c3));
    }
}
