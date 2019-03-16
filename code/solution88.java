/* https://leetcode.com/problems/pacific-atlantic-water-flow/ */
public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        
        List<int[]> sol = new ArrayList();
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return sol;
        
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[][] p=new boolean[m][n];
        boolean[][] a=new boolean[m][n];
        
        for(int i=0;i<m;i++){
            dfs(matrix,p,Integer.MIN_VALUE,i,0);
            dfs(matrix,a,Integer.MIN_VALUE,i,n-1);
        }
        
        for(int i=0;i<n;i++){
            dfs(matrix,p,Integer.MIN_VALUE,0,i);
            dfs(matrix,a,Integer.MIN_VALUE,m-1,i);
        }
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(p[i][j] && a[i][j]){
                    int ar[]=new int[2];
                    ar[0]=i;ar[1]=j;
                    sol.add(ar);
                }
        
        return sol;
    }
    
    public void dfs(int[][] m, boolean[][] v, int prev, int i, int j){
        
        if(i<0 || j<0 || i>=m.length || j>=m[0].length || v[i][j] || m[i][j]<prev)
            return;
        
        v[i][j]=true;
        dfs(m,v,m[i][j],i+1,j);
        dfs(m,v,m[i][j],i,j+1);
        dfs(m,v,m[i][j],i-1,j);
        dfs(m,v,m[i][j],i,j-1);
    }
}
