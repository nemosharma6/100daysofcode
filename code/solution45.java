/* https://leetcode.com/problems/arithmetic-slices-ii-subsequence/ */

class Solution {
    
    int c = 0;
    
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length <= 2) return 0;
        helper(A, Integer.MAX_VALUE, 0, Long.MAX_VALUE, 0);
        return c;
    }
    
    public void helper(int A[], int last, int ct, long diff, int j){
        for(int i=j;i<A.length;i++){
            if(ct > 1){
                long d = getDiff(A[i], last);
                if(d == diff) {
                    helper(A, A[i], ct+1, diff, i+1);
                    c++;
                }
            } else {
                if(ct == 0)
                    helper(A, A[i], 1, Integer.MAX_VALUE, i+1);
                else
                    helper(A, A[i], 2, getDiff(A[i], last), i+1);
            }
        }
    }
    
    public long getDiff(long a, long b){
        return a-b;
    }
}
