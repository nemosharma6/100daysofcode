/* https://leetcode.com/problems/reverse-bits/ */
public class Solution {
    public int reverseBits(int n) {
        int m=n&1;
        n=n>>>1;
        for(int i=0;i<31;i++){
            m=m<<1;
            m+=n&1;
            n=n>>>1;
        }
        
        return m;
    }
}
