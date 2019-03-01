/* https://leetcode.com/problems/task-scheduler/ */

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(tasks.length == 0 || tasks.length == 1 || n == 0)
            return tasks.length;
        
        int fr[] = new int[26];
        
        int mx=0;
        int ct=0;
        
        for(int i=0;i<tasks.length;i++){
            fr[tasks[i]-65]++;
            
            int tmp = fr[tasks[i]-65];
            
            if(tmp == mx)
                ct++;
            
            if(tmp > mx) {
                mx = tmp;
                ct=1;
            }
        }
        
        int tmp = (mx-1)*(n+1) + ct;
        if(tmp < tasks.length)
            return tasks.length;
        
        return tmp;
    }
}
