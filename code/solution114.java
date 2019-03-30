/* https://leetcode.com/problems/subarrays-with-k-different-integers/ */
class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        
        if(A.length==0 || A.length<K)
            return 0;
        
        int[] ar=new int[20001];
        int[] ar1=new int[20001];
        int c=0,i=0,u=0,s=0;
        
        while(true){
            
            if(i==A.length)
                break;
            
            for(int j=s;j<=i;j++)
                ar1[A[j]]=ar[A[j]];
            
            while(i<A.length){
                if(ar[A[i]]==0 && u==K) break;
                if(ar[A[i]]==0) u++;
                ar[A[i]]++;
                ar1[A[i]]++;
                i++;
                if(u==K){
                    c++;
                    int br=s;
                    for(int j=s;j<i;j++){
                        ar1[A[j]]--;
                        if(ar1[A[j]]==0) {
                            br=j;
                            break;
                        }
                        c++;
                    }
                    
                    for(int j=s;j<=br;j++)
                        ar1[A[j]]++;
                }
            }
            
            while(s<i && u==K){
                ar[A[s]]--;
                if(ar[A[s]]==0) {
                    u--;
                    s++;
                    break;
                }
                s++;
            }
        }
        
        return c;
    }
}
