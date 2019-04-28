/* https://leetcode.com/problems/coloring-a-border/ */
class Solution {
    List<int[]> li=new ArrayList();
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int t=grid[r0][c0];
        dfs(grid,r0,c0,new boolean[grid.length][grid[0].length],t);
        int mx1=Integer.MIN_VALUE,mx2=Integer.MIN_VALUE,mn1=Integer.MAX_VALUE,mn2=Integer.MAX_VALUE;
        for(int[] tmp: li){
            mx1=Math.max(mx1,tmp[0]); // max row
            mx2=Math.max(mx2,tmp[1]);
            mn1=Math.min(mn1,tmp[0]); // min row
            mn2=Math.min(mn2,tmp[1]);
        }
        
        int[][] sol=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++) for(int j=0;j<grid[0].length;j++) sol[i][j]=grid[i][j];
        for(int[] tmp: li){
            
            if(tmp[0]==mn1 || tmp[1]==mn2 || tmp[0]==mx1 || tmp[1]==mx2) {
                sol[tmp[0]][tmp[1]]=color;
                continue;
            }
            
            int r=tmp[0],c=tmp[1];
            boolean ch=false;
            if(r>0) ch=ch||(grid[r-1][c]!=t);
            if(r<grid.length-1) ch=ch||(grid[r+1][c]!=t);
            if(c>0) ch=ch||(grid[r][c-1]!=t);
            if(c<grid[0].length-1) ch=ch||(grid[r][c+1]!=t);
            if(ch) sol[r][c]=color;
        }
        
        return sol;
    }
    
    public void dfs(int[][] g, int r, int c, boolean[][] v, int curr){
        if(r<0||c<0||r==g.length||c==g[0].length) return;
        if(g[r][c]!=curr || v[r][c]) return;
        v[r][c]=true;
        li.add(new int[]{r,c});
        dfs(g,r+1,c,v,curr);
        dfs(g,r,c+1,v,curr);
        dfs(g,r-1,c,v,curr);
        dfs(g,r,c-1,v,curr);
    }
}
