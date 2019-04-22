/* https://leetcode.com/problems/smallest-integer-divisible-by-k/ */
class Solution {
    public int smallestRepunitDivByK(int K) {
        if((K%10)%2==0) return -1;
        int n=0;
        boolean[] tmp=new boolean[K];
        for(int i=1;i<=K;i++){
            n=(n*10+1)%K;
            if(n==0) return i;
            if(tmp[n]) return -1;
            tmp[n]=true;
        }
        
        return -1;
    }
}
