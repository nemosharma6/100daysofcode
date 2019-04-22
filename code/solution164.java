/* https://leetcode.com/problems/best-sightseeing-pair/ */
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int n=A.length,max=A[n-1]-n+1,sol=0;
        for(int i=n-2;i>=0;i--){
            sol=Math.max(A[i]+i+max,sol);
            max=Math.max(max,A[i]-i);
        }
        
        return sol;
    }
}
