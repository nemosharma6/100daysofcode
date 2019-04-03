/* https://leetcode.com/problems/sum-of-subarray-minimumst/ */
class Solution {
    public int sumSubarrayMins(int[] A) {
        
        /*
        improvement: use stack to get index of next greater element. 
        same could be done for next smaller element. best complexity would be O(n)
        */
        
        long c=0;
        int md=1000000007;
        for(int i=0;i<A.length;i++){
            int s=i-1,e=i;
            while(s>=0 && A[i]<A[s]) s--;
            while(e<A.length && A[i]<=A[e]) e++;
            s++; e--;
            int l=e-i+1;
            if(s<i) l+=i-s;
            if(s<i && e>i) l+=(e-i)*(i-s);
            c+=A[i]*l;
            c=c%md;
        }
        
        return (int)c;
    }
}
