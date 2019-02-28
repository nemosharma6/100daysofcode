/* https://leetcode.com/problems/subarray-sum-equals-k/ */

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap();
        int s=0;
        int ct=0;
        
        for(int i=0;i<nums.length;i++) {
            s += nums[i];
            
            if(s == k) ct += 1;
            
            if(map.containsKey(s-k)) 
                ct += map.get(s-k);
            
            if(map.containsKey(s))
                map.put(s, map.get(s)+1);
            else
                map.put(s, 1);
        }
        
        return ct;
    }
}
