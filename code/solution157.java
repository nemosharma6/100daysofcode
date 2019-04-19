/* https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/ */
class Solution {
    public int minKBitFlips(int[] A, int K) {
        int c=0,i=0;
        while(true){
            while(i<A.length && A[i]==1) i++;
            if(i==A.length) break;
            if(A.length-i<K) return -1;
            for(int j=i;j<i+K;j++) A[j]=1-A[j];
            c++;
        }
        
        return c;
    }
}
