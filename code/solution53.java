/* https://leetcode.com/problems/longest-consecutive-sequence/ */

class Solution {
    public int longestConsecutive(int[] nums) {
        
        Map<Integer, Integer> mp = new HashMap();
        int sol = 0;
        
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(!mp.containsKey(num)){
                
                if(mp.containsKey(num-1))
                    mp.put(num, mp.get(num-1)+1);
                else
                    mp.put(num, 1);
                
                while(true){
                    if(!mp.containsKey(num+1))
                        break;
                    
                    mp.put(num+1, mp.get(num) + 1);
                    num++;
                }
                
                if(sol < mp.get(num))
                    sol = mp.get(num);
            }
        }
        
        return sol;
        
    }
}
