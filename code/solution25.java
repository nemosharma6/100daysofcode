/* https://leetcode.com/problems/course-schedule-ii/ */

class Solution {
    
    Stack<Integer> st = new Stack();
    boolean status = false;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        boolean pre[][] = new boolean[numCourses][numCourses];
        boolean conflict = false;
        
        for(int i=0;i<prerequisites.length;i++)
            pre[prerequisites[i][0]][prerequisites[i][1]] = true;
        
        boolean vis[] = new boolean[numCourses];
        boolean here[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
            helper(pre, i, vis, here);
        
        if(status) return new int[0];
        
        int sol[] = new int[numCourses];
        int c = numCourses-1;
        
        
        while(!st.isEmpty())
            sol[c--] = st.pop();
        
        return sol;
    }
    
    public void helper(boolean pre[][], int i, boolean vis[], boolean here[]){
        
        if(vis[i]) return;
        if(here[i]) {
            status = true;
            return;
        }
        
        here[i] = true;
        for(int j=0;j<pre.length;j++){
            if(status) return;
            if(i != j && pre[i][j]) helper(pre, j, vis, here);
        }
        
        vis[i] = true;
        st.push(i);
    }
}
