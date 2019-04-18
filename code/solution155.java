/* https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/ */
class Solution {
    public int removeDuplicates(int[] nums) {
        int pos=2;
        for(int i=2;i<nums.length;){
            if(nums[i]==nums[pos-1] && nums[i]==nums[pos-2]) i++;
            else {
                int t=nums[pos];
                nums[pos]=nums[i];
                nums[i]=t;
                pos++;
                i++;
            }
        }
        
        return pos;
    }
}
