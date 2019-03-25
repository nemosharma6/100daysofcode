/* https://leetcode.com/problems/partition-to-k-equal-sum-subsets/ */
class Solution {
    
    boolean done = false;
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            max=Math.max(nums[i],max);
        }
        
        if(total%k!=0 || max>total/k)
            return false;
        
        List<Integer> l = new ArrayList();
        for(int i=0;i<nums.length;i++)
            l.add(nums[i]);
        
        return check(l,total/k,0);
    }
    
    public boolean check(List<Integer> l, int v, int sum){
        
        if(sum==v && l.size()==0){
            done = true;
            return true;
        }
        
        if(l.size()==0){
            done = true;
            return false;
        }
        
        if(sum==v)
            return check(l,v,0);
        
        if(sum>v)
            return false;
        
        for(int i=0;i<l.size();i++){
            int num = l.get(i);
            if(sum+num>v) continue;
            l.remove(i);
            boolean b = check(l, v, sum+num);
            if(done) return b;
            l.add(i,num);
        }
        
        return false;
    }
}
