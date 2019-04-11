/* https://leetcode.com/problems/jump-game-ii/ */
class Solution {
    
    public int jump(int[] nums) {
        if(nums.length==0 || nums.length==1) return 0;
        if(nums[0]>0 && nums[0]>=nums.length-1) return 1;
        if(nums[0]>0 && nums.length-nums[0]-1==1) return 2;
        
        int[] d=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            d[i]=Integer.MAX_VALUE;
            for(int j=0;j<=i;j++)
                if(nums[j]+j>=i) d[i]=Math.min(d[i],1+d[j]);
        }
        
        return d[nums.length-1];
    }
}
