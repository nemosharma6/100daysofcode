/* https://leetcode.com/problems/shortest-path-visiting-all-nodes/ */
class Solution {
    
    class Tuple {
        
        int vis, src, len;
    
        public Tuple(int v, int s, int l){
            vis=v;
            src=s;
            len=l;
        }

        public boolean equals(Object o){
            Tuple p = (Tuple) o;
            return vis == p.vis && src == p.src && len == p.len;
        }

        public int hashCode(){
            return 1331 * vis + 7193 * src + 727 * len;
        }
    }
    
    public int shortestPathLength(int[][] graph) {
        
        Queue<Tuple> queue = new LinkedList<>();
        Set<Tuple> set = new HashSet<>();

        for(int i = 0; i < graph.length; i++){
            int tmp=(1 << i);
            set.add(new Tuple(tmp, i, 0));
            queue.add(new Tuple(tmp, i, 1));
        }
        
        while(!queue.isEmpty()){
            Tuple tup = queue.poll();
    
            if(tup.vis == (1<<graph.length)-1) return tup.len - 1;
            else { 
                for(int v: graph[tup.src]){
                    int vis=tup.vis;
                    vis=vis|(1 << v);
                    
                    Tuple t = new Tuple(vis, v, 0);
                    if(!set.contains(t)){
                        queue.add(new Tuple(vis,v,tup.len+1));
                        set.add(t);
                    }         
                }
            }
        }
        
        return -1;
    }
}
