/* https://leetcode.com/problems/search-a-2d-matrix/ */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int l=0,r=matrix.length*matrix[0].length-1;
        
        while(l<=r){
            int m=(l+r)/2;
            int ro=m/matrix[0].length;
            int co=m%matrix[0].length;
            
            if(matrix[ro][co]==target) return true;
            if(matrix[ro][co]>target)
                r=m-1;
            else
                l=m+1;
        }
        
        return false;
    }
}
