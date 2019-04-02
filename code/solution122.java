/* https://leetcode.com/problems/number-of-music-playlists/ */
class Solution {
    
    int c=0;
    int md=1000000007;
    public int numMusicPlaylists(int N, int L, int K) {
        
        long[][] dp=new long[L+1][N+1];
        dp[0][0]=1;
        
        for(int i=1;i<=L;i++){
            for(int j=1;j<=N;j++){
                dp[i][j]=dp[i-1][j-1]*(N-j+1);
                if(j>K)
                    dp[i][j]+=dp[i-1][j]*(j-K);
                
                dp[i][j]=dp[i][j]%md;
            }
        }
        
        return (int)dp[L][N];
        // rec(N,L,K,new int[N],1,0);
        // return c;
    }
    
    public void rec(int n, int l, int k, int[] occ, int id, int dist){
        
        if(id==l+1){
            if(dist==n){
                c++;
                c=c%md;
            }
            return;
        }
        
        for(int i=0;i<n;i++){
            int tmp=occ[i];
            if(tmp==0 || id-tmp>=k+1){
                occ[i]=id;
                int d=dist;
                if(tmp==0)d++;
                rec(n,l,k,occ,id+1,d);
                occ[i]=tmp;
            }
        }
    }
}
