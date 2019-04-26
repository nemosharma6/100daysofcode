/* https://leetcode.com/problems/delete-columns-to-make-sorted-iii/ */
class Solution {
    public int minDeletionSize(String[] A) {
        int mx=1;
        int[] dp=new int[A[0].length()];
        Arrays.fill(dp,1);
        for(int i=0;i<A[0].length();i++){
            for(int j=0;j<i;j++){
                boolean chk=true;
                for(int k=0;k<A.length;k++)
                    chk=chk&&(A[k].charAt(i)>=A[k].charAt(j));
                if(chk)
                    dp[i]=Math.max(dp[i],1+dp[j]);
            }
            mx=Math.max(mx,dp[i]);
        }
        
        return A[0].length()-mx;
    }
}
