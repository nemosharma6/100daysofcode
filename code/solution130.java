/* https://leetcode.com/problems/making-a-large-island/ */
class Solution {
    public int largestIsland(int[][] A) {
        int sol=0, m=A.length, n=A[0].length;
        List<List<int[]>> is=new ArrayList();
        boolean[][] v=new boolean[m][n];
        boolean zero=false;
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(v[i][j]) continue;
                if(A[i][j]==1) {
                    List<int[]> li=new ArrayList();
                    dfs(A,i,j,li,v);
                    is.add(li);
                    sol=Math.max(sol,li.size());
                }
            }
        
        if(zero) sol++;
        
        int[][] len=new int[m][n];
        for(int i=0;i<is.size();i++)
            for(int j=0;j<is.get(i).size();j++){
                int[] pt=is.get(i).get(j);
                len[pt[0]][pt[1]]=i+1;
            }
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(len[i][j]==0){
                    int s=0;
                    List<Integer> set=new ArrayList();
                    if(i-1>=0 && len[i-1][j]!=0 && !set.contains(len[i-1][j])) 
                        set.add(len[i-1][j]);
                    if(i+1<m && len[i+1][j]!=0 && !set.contains(len[i+1][j])) 
                        set.add(len[i+1][j]);
                    if(j-1>=0 && len[i][j-1]!=0 && !set.contains(len[i][j-1])) 
                        set.add(len[i][j-1]);
                    if(j+1<n && len[i][j+1]!=0 && !set.contains(len[i][j+1])) 
                        set.add(len[i][j+1]);
                    
                    for(Integer x: set) s+=is.get(x-1).size();
                    sol=Math.max(sol, s+1);
                }
        
        return sol;
    }
    
    public void dfs(int[][] a, int i, int j, List<int[]> is, boolean[][] v){
        if(i<0||j<0||i==a.length||j==a[0].length||a[i][j]==0||v[i][j]) return;
        v[i][j]=true;
        is.add(new int[]{i,j});
        dfs(a,i+1,j,is,v);
        dfs(a,i,j+1,is,v);
        dfs(a,i-1,j,is,v);
        dfs(a,i,j-1,is,v);
    }
}
