/* https://leetcode.com/problems/binary-subarrays-with-sum/ */
class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] map=new int[A.length+1];
        int s=0,c=0;
        for(int i: A){
            s+=i;
            if(s==S) c++;
            if(s>=S) c+=map[s-S];
            map[s]++;
        }
        
        return c;
    }
}
