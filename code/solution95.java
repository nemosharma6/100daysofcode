/* https://leetcode.com/problems/word-subsets/ */
class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        
        int b[] = new int[26];
        int[] tmp=new int[26];
        List<String> sol = new ArrayList();
        
        for(int i=0;i<B.length;i++){
            
            for(int j=0;j<B[i].length();j++)
                tmp[B[i].charAt(j)-97]++;
            
            for(int j=0;j<26;j++) {
                b[j]=Math.max(b[j],tmp[j]);
                tmp[j]=0;
            }
        }
        
        for(int i=0;i<A.length;i++){
            int a[]=new int[26];
            for(int j=0;j<A[i].length();j++)
                a[A[i].charAt(j)-97]++;
            
            if(contains(a,b))
                sol.add(A[i]);
        }
        
        return sol;
        
    }
    
    public boolean contains(int[] a, int[] b){
        for(int i=0;i<a.length;i++)
            if(a[i]<b[i])
                return false;
        
        return true;
    }
}
