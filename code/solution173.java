/* https://leetcode.com/problems/k-closest-points-to-origin/ */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue=new PriorityQueue(points.length, new Comparator<int[]> () {
            @Override
            public int compare(int[] e1, int[] e2) {
                return e1[0]*e1[0]+e1[1]*e1[1] - (e2[0]*e2[0]+e2[1]*e2[1]);
            }
        });
        
        for(int[] p: points) queue.offer(p);
        int[][] sol=new int[K][2];
        for(int i=0;i<K;i++){
            int[] p=queue.poll();
            sol[i][0]=p[0];
            sol[i][1]=p[1];
        }
        
        return sol;
    }
}
