/* https://leetcode.com/problems/subarrays-with-k-different-integers/ */
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        int k1=atmost(A,K);
        int k2=atmost(A,K-1);
        return k1-k2;
    }
    
    public int atmost(int[] a, int k){
        int c=0,u=0;
        int[] ar=new int[20001];
        
        int j=0;
        for(int i=0;i<a.length;i++){
            if(ar[a[i]]==0) u++;
            ar[a[i]]++;
            
            if(u>k){
                while(j<a.length){
                    ar[a[j]]--;
                    if(ar[a[j]]==0) break;
                    j++;
                }
                j++;
                u--;
            }
            
            c+=i-j+1;
        }
        
        return c;
    }
}
