/* https://leetcode.com/problems/majority-element/ */
class Solution {
    public int majorityElement(int[] nums) {
        int m=nums[0], c=1;
        for(int i=1;i<nums.length;i++){
            if(m==nums[i]) c++;
            else c--;
            if(c==0) {
                m=nums[i];
                c++;
            }
        }
        
        return m;
    }
}
