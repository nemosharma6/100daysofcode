/* https://leetcode.com/problems/next-permutation/ */
class Solution {
    public void nextPermutation(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1)
            return;
        
        int end = nums.length - 1;
        while(end > 0 && nums[end] <= nums[end - 1])
            end--;
        
        if(end == 0)
            Arrays.sort(nums);
        else {
            
            int sm = nums[end];
            int ind = end;
            for(int i=end;i<nums.length;i++)
                if(nums[i] < sm && nums[i] > nums[end-1]) {
                    sm = nums[i];
                    ind = i;
                }
            
            int tmp = nums[ind];
            nums[ind] = nums[end-1];
            nums[end-1] = tmp;
            
            Arrays.sort(nums, end, nums.length);
        }
        
    }
}
