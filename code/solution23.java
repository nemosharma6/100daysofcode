/* https://leetcode.com/problems/single-element-in-a-sorted-array/ */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int l, m, r;
        l = 0;
        r = nums.length - 1;
        
        while(l <= r){
            m = (l + r) / 2;
            
            if(m == 0 && nums[m] != nums[m+1]) return nums[m];
            if(m == nums.length-1 && nums[m] != nums[m-1]) return nums[m];
            if(m >= 1 && nums[m] != nums[m-1] && m<nums.length-1 && nums[m] != nums[m+1])
               return nums[m];
            
            if(m % 2 == 0){
                if(nums[m] == nums[m+1]) l = m+1;
                else r = m-1;
            } else {
                if(nums[m] == nums[m-1]) l = m+1;
                else r = m-1;
            }
        }
        
        return 0;
        
    }
}
