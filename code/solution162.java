/* https://leetcode.com/problems/number-of-enclaves/ */
class Solution {    
    boolean status=false;
    int ct=0;
    public int numEnclaves(int[][] A) {
        boolean[][] v=new boolean[A.length][A[0].length];
        int c=0;
        for(int i=0;i<A.length;i++)
            for(int j=0;j<A[0].length;j++){
                if(!v[i][j]){
                    status=false;
                    ct=0;
                    connected(A,i,j,v);
                    if(!status) c+=ct;
                }
            }
        
        return c;
    }
    
    public void connected(int[][] A, int i, int j, boolean[][] v){
        if(i<0 || j<0 || i>=A.length || j>=A[0].length) return;
        if(A[i][j]==0 || v[i][j]) return;
        if(i==0 || i==A.length-1 || j==0 || j==A[0].length-1) status=true;
        v[i][j]=true;
        ct++;
        connected(A,i,j+1,v);
        connected(A,i+1,j,v);
        connected(A,i,j-1,v);
        connected(A,i-1,j,v);
    }
}
