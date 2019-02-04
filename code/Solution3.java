// https://leetcode.com/problems/product-of-array-except-self/submissions/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        if(nums.length == 0 || nums.length == 1) return nums;
        
        int right[] = new int[nums.length];
        
        right[nums.length - 1] = nums[nums.length - 1];
        for(int i=nums.length-2;i>=0;i--){
            right[i] = right[i+1] * nums[i];
        }
        
        int out[] = new int[nums.length];
        int left = 1;
        for(int i=0;i<nums.length;i++){
            if(i==0) out[0] = right[1];
            else if(i==nums.length-1) out[i] = left;
            else out[i] = left * right[i+1];
            left = left * nums[i];
        }
        
        return out;
        
    }
}
