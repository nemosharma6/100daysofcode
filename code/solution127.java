/* https://leetcode.com/problems/subarray-sums-divisible-by-k/ */
class Solution {
    public int subarraysDivByK(int[] A, int K) {
        
        int[] a=new int[K];
        int s=0,c=0;
        for(int i=0;i<A.length;i++){
            s=(s+A[i])%K;
            if(s<0) s+=K;
            if(s==0) c++;
            c+=a[s];
            a[s]++;
        }
        
        return c;
    }
}
