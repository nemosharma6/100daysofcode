/* https://leetcode.com/problems/flower-planting-with-no-adjacent/ */
class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        List<List<Integer>> li=new ArrayList();
        for(int i=0;i<=N;i++) li.add(new ArrayList());
        for(int i=0;i<paths.length;i++){
            li.get(paths[i][0]).add(paths[i][1]);
            li.get(paths[i][1]).add(paths[i][0]);
        }
        
        int[] sol=new int[N];
        for(int i=1;i<=N;i++){
            boolean[] u=new boolean[4];
            for(int j: li.get(i)) if(sol[j-1]>0) u[sol[j-1]-1]=true;
            
            int j;
            for(j=0;j<4;j++) if(u[j]==false) break;
            sol[i-1]=j+1;
        }
        
        return sol;
    }
}
