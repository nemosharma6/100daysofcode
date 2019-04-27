/* https://leetcode.com/problems/find-k-pairs-with-smallest-sums/ */
class Solution {
    public List<int[]> kSmallestPairs(int[] n1, int[] n2, int k) {
        List<int[]> sol=new ArrayList();
        if(n1.length==0 || n2.length==0) return sol;
        int[] c=new int[n2.length];
        while(true){
            int m1=Integer.MAX_VALUE,m2=0;
            for(int i=0;i<n2.length;i++){
                if(c[i]<n1.length){
                    m1=Math.min(m1, n1[c[i]]+n2[i]);
                    if(m1==n1[c[i]]+n2[i]) m2=i;
                }
            }
            
            if(m1==Integer.MAX_VALUE) return sol;
            sol.add(new int[]{n1[c[m2]], n2[m2]});
            c[m2]++;
            if(sol.size()==k) break;
        }
        
        return sol;
    }
}
