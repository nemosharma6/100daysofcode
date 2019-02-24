/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

int maxProfit(int* prices, int pricesSize) {
    
    if(pricesSize == 0) return 0;
    int* left = (int *)malloc(pricesSize * sizeof(int));
    
    left[0] = prices[0];
    for(int i=1;i<pricesSize;i++){
        if(left[i-1] > prices[i]) left[i] = prices[i];
        else left[i] = left[i-1];
    }
    
    int mx = prices[pricesSize - 1];
    int sol = 0;
    for(int i=pricesSize-2;i>=0;i--){
        if(mx < prices[i]) mx = prices[i];
        if(mx - left[i] > sol) sol = mx - left[i];
    }
    
    return sol;
}
