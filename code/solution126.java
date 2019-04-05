/* https://leetcode.com/problems/shortest-bridge/ */
class Solution {    
    public int shortestBridge(int[][] A) {
        List<int[]> i1=new ArrayList();
        List<int[]> i2=new ArrayList();
        
        int c=0;
        boolean over=false;
        boolean[][] v=new boolean[A.length][A[0].length];
        for(int i=0;i<A.length;i++) {
            for(int j=0;j<A[0].length;j++){
                if(v[i][j]) continue;
                if(A[i][j]==1 && c==0) {
                    dfs(A,i,j,i1,v);
                    c++;
                } else if(A[i][j]==1 && c==1) {
                    c++;
                    dfs(A,i,j,i2,v);
                } else if(c==2) {
                    over=true;
                    break;
                }
            }
            
            if(over) 
                break;
        }
        
        int d=Integer.MAX_VALUE;
        for(int i=0;i<i1.size();i++) 
            for(int j=0;j<i2.size();j++){
                int x=Math.abs(i1.get(i)[0]-i2.get(j)[0]);
                int y=Math.abs(i1.get(i)[1]-i2.get(j)[1]);
                d=Math.min(d, x+y);
            }
        
        return d-1;
    }
    
    public void dfs(int[][] a, int i, int j, List<int[]> is, boolean[][] v){
        if(i<0 || j<0 || i==a.length || j==a[0].length || a[i][j]==0 || v[i][j]) return;
        v[i][j]=true;
        is.add(new int[]{i,j});
        dfs(a,i+1,j,is,v);
        dfs(a,i,j+1,is,v);
        dfs(a,i-1,j,is,v);
        dfs(a,i,j-1,is,v);
    }
}
