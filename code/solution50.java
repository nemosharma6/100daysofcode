/* https://leetcode.com/problems/longest-increasing-subsequence/ */

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1) return nums.length;
        
        int sol[] = new int[nums.length];
        sol[0] = 1;
        
        int mx = 1;
        for(int i=1;i<nums.length;i++){
            sol[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) 
                    sol[i] = Math.max(sol[i], 1+sol[j]);
            }
            
            if(sol[i] > mx)
                mx = sol[i];
        }
        
        return mx;
    }
}
