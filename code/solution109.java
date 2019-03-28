/* https://leetcode.com/problems/gas-station/ */
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int min=Integer.MAX_VALUE;
        int ind=-1;
        int prev=0;
        for(int i=0;i<gas.length;i++){
            
            if(gas[i]-cost[i]+prev <= min){
                min=gas[i]-cost[i]+prev;
                ind=i;
            }
            
            prev=gas[i]-cost[i]+prev;
        }
        
        if(ind==-1)
            return -1;
        
        if(prev>=0){
            if(ind+1==gas.length) return 0;
            return ind+1;
        }
        
        return -1;
    }
}
