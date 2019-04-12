/* https://leetcode.com/problems/numbers-with-same-consecutive-differences/ */
class Solution {
    
    List<Integer> li=new ArrayList();
    public int[] numsSameConsecDiff(int N, int K) {
        for(int i=1;i<=9;i++)
            rec(i,1,K,N);
        
        int[] sol;
        if(N==1) sol=new int[li.size()+1]; else sol=new int[li.size()];
        for(int i=0;i<li.size();i++) sol[i]=li.get(i);
        return sol;
    }
    
    public void rec(int num, int j, int k, int n){
        if(j==n) {
            li.add(num);
            return;
        }
        
        int p=num%10;
        if(p-k>=0)
            rec(num*10+p-k,j+1,k,n);
        if(p+k<10 && p+k!=p-k)
            rec(num*10+p+k,j+1,k,n);
    }
}
