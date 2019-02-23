/* https://leetcode.com/problems/counting-bits/ */

class Solution {
    public int[] countBits(int num) {
        int bits[] = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
        
        int ar[] = new int[num+1];
        ar[0] = 0;
        
        for(int i=1;i<=num;i++){
            int j=i;
            int s=0;
            while(j != 0){
                int t = 0xf & j;
                s = s + bits[t];
                j = j >> 4;
            }
            ar[i] = s;
        }
        
        return ar;
    }
}
