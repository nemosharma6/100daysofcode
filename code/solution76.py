# https://leetcode.com/problems/search-a-2d-matrix-ii/
class Solution:
    def searchMatrix(self, matrix, target):
        
        i=0
        if len(matrix)==0:
            return False
        
        j=len(matrix[0])-1
        if len(matrix[0])==0:
            return False
        
        while i<len(matrix) and j>=0:
            if matrix[i][j]==target:
                return True
            
            if matrix[i][j]>target:
                j-=1
            else:
                i+=1
                
        return False
        
