/* https://leetcode.com/problems/kth-largest-element-in-an-array/ */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return 0;
        return helper(nums, 0, nums.length-1, k);
    }
    
    public int helper(int[] nums, int l, int r, int k){
        
        int p = partition(nums, l, r);
        
        if(p-l == k-1) return nums[p];
        
        if(p-l > k-1)
            return helper(nums, l, p-1, k);
        
        return helper(nums, p+1, r, k-p+l-1);
    }
    
    public int partition(int[] nums, int l, int r){
        
        int pivot = nums[r];
        int i = l, j = r-1;
        
        while(true){
            
            if(i>j) break;
            
            if(nums[i] < pivot){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j--;
            } else
                i++;
        }
        
        nums[r] = nums[i];
        nums[i] = pivot;
        return i;
    }
}
