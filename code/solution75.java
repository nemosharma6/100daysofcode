/* https://leetcode.com/problems/largest-rectangle-in-histogram/ */
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length==0)
            return 0;
        
        return helper(heights, 0, heights.length);
    }
    
    public int helper(int[] h, int l, int r){
        
        int min = Integer.MAX_VALUE;
        int m = -1;
        for(int i=l;i<r;i++)
            if(h[i] <= min){
                min = h[i];
                m = i;
            }
        
        int left;
        if(m == l) left = h[l];
        else left = helper(h, l, m);
        
        int right;
        if(m == r-1) right = h[m];
        else right = helper(h, m+1, r);
        
        int ar = (r-l)*min;
        
        return Math.max(ar, Math.max(left, right));
    }
}
