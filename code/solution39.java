/* https://leetcode.com/problems/target-sum/ */

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, S, 0, 0);
    }
    
    public int helper(int nums[], int s, int sum, int i){
        if( i== nums.length){
            if(s == sum) return 1;
            else return 0;
        }
        
        int c1 = helper(nums, s, sum+nums[i], i+1);
        int c2 = helper(nums, s, sum-nums[i], i+1);
        return c1 + c2;
    }
}
