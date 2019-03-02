# https://leetcode.com/problems/rotate-image/
class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        
        row = len(matrix)
        
        if row == 0 or row == 1:
            return
        
        col = len(matrix[0])
        
        for i in range(0, row):
            for j in range(0, i):
                tmp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = tmp
                
        for i in range(0, row):
            for j in range(0, int(col/2)):
                tmp = matrix[i][j]
                matrix[i][j] = matrix[i][col-1-j]
                matrix[i][col-1-j] = tmp
