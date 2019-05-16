/* https://leetcode.com/problems/redundant-connection/ */
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int p[] = new int[edges.length+1];
        int pop=uf(edges,p);
        Set<Integer> set=new HashSet();
        for(int i=0;i<p.length;i++)
            if(p[i]==pop) set.add(i);
        
        int ind=-1;
        for(int i=0;i<edges.length;i++)
            if(set.contains(edges[i][0]) && set.contains(edges[i][1]))
                ind=i;
        
        return edges[ind];
    }
    
    public int uf(int[][] edges, int[] p){
        Arrays.fill(p,-1);
        for (int i=0; i<edges.length; i++) { 
            int x=find(p, edges[i][0]); 
            int y=find(p, edges[i][1]); 
            if(x==y){
                union(p, x, y);
                return x;
            }
            union(p, x, y); 
        }
        return 0;
    }
    
    public int find(int p[], int i) { 
        if (p[i] == -1 || p[i]==i) return i; 
        p[i]=find(p, p[i]); 
        return p[i];
    } 
  
    public void union(int p[], int x, int y) { 
        int xset = find(p, x); 
        int yset = find(p, y); 
        p[xset] = yset; 
    } 
}
