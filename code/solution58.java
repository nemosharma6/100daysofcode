/* https://leetcode.com/problems/maximal-rectangle/ */

class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if(matrix.length == 0)
            return 0;
        
        int tmp[][] = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[0].length;j++){
                tmp[i][j] = matrix[i][j] - '0';
                if(i>0 && tmp[i][j] == 1)
                    tmp[i][j] += tmp[i-1][j];
            }
        
        
        int max = 0;
        
        for(int i=0;i<tmp.length;i++){
            for(int j=0;j<tmp[0].length;j++){
                
                if(j>0 && tmp[i][j] == tmp[i][j-1])
                    continue;
                
                int best = 0;
                int mn = Integer.MAX_VALUE;
                for(int k=j;k<tmp[0].length;k++) {
                    mn = Math.min(mn, tmp[i][k]);
                    best = Math.max(best, mn * (k-j+1));
                }
                
                max = Math.max(max, best);
            }
        }
        
        return max;
        
    }
}
