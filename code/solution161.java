/* https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/ */
class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] m1=new int[A.length-L+1], m2=new int[A.length-M+1];
        int s=0;
        for(int i=0;i<A.length;i++){
            if(i<L) s+=A[i];
            else {
                m1[i-L]=s;
                s-=A[i-L];
                s+=A[i];
            }
        }
        
        m1[A.length-L]=s;
        
        s=0;
        for(int i=0;i<A.length;i++){
            if(i<M) s+=A[i];
            else {
                m2[i-M]=s;
                s-=A[i-M];
                s+=A[i];
            }
        }
        
        m2[A.length-M]=s;
        
        int[] rmax=new int[A.length-M+1], lmax=new int[A.length-M+1];
        rmax[A.length-M]=m2[A.length-M];
        for(int i=A.length-M-1;i>=0;i--)
            rmax[i]=Math.max(m2[i],rmax[i+1]);
        
        lmax[0]=m2[0];
        for(int i=1;i<A.length-M;i++)
            lmax[i]=Math.max(m2[i],lmax[i-1]);
        
        int sol=0,c=0;
        for(int i=0;i<m1.length;i++){
            if(i+L<rmax.length) sol=Math.max(sol,m1[i]+rmax[i+L]);
            if(i>=M && c<lmax.length) {
                sol=Math.max(sol,m1[i]+lmax[c]);
                c++;
            }
        }
        
        return sol;
    }
}
