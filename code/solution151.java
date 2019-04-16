/* https://leetcode.com/problems/split-array-largest-sum/ */
class Solution {
    
    public int splitArray(int[] nums, int m) {
        long l=0,r=0;
        for(int i: nums){
            l=Math.max(i,l);
            r+=i;
        }
        
        if(m==1) return (int)r;
        while(l<=r){
            long mid=(l+r)/2;
            if(valid(nums,mid,m))
                r=mid-1;
            else
                l=mid+1;
        }
        
        return (int)l;
    }
    
    public boolean valid(int[] nums, long sum, int m){
        long s=0,c=1;
        for(int i: nums){
            s+=i;
            if(s>sum){
                s=i;
                c++;
                if(c>m) return false;
            }
        }
        
        return true;
    }
}
