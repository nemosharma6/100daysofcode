// https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        
        int l, m, h;
        l = m = 0;
        h = nums.length - 1;
        
        while(m <= h){
            
            if(nums[m] == 0){
                nums[m] = nums[l];
                nums[l] = 0;
                l++;
                m++;
            } 
            else 
                if(nums[m] == 1) m++;
            else {
                nums[m] = nums[h];
                nums[h] = 2;
                h--;
            }
        }
    }
}
