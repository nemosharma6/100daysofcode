/* https://leetcode.com/problems/distinct-subsequences-ii/ */
class Solution {
    public int distinctSubseqII(String S) {
        long[] c=new long[S.length()];
        int m=(int)1e9+7;
        Arrays.fill(c,1);
        long s=0;
        for(int i=0;i<S.length();i++){
            for(int j=0;j<i;j++){
                if(S.charAt(j)!=S.charAt(i)){
                    c[i]+=c[j];
                    c[i]%=m;
                }
            }
            s+=c[i];
            s%=m;
        }
        return (int)s;
    }
}
