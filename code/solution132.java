/* https://leetcode.com/problems/count-of-range-sum/ */
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        
        long c=0,s=0;
        Map<Long, Integer> set=new HashMap();
        set.put(0L, 1);
        for(int i=0;i<nums.length;i++){
            s+=nums[i];
            for(long j=lower;j<=upper;j++)
                if(set.containsKey(s-j))
                    c+=set.get(s-j);
            
            set.put(s, set.getOrDefault(s,0)+1);
        }
        
        return (int)c;
    }
}
