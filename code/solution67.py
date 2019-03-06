# https://leetcode.com/problems/maximal-square/
class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        if len(matrix) == 0:
            return 0
        
        if len(matrix) == 1 or len(matrix[0]) == 1:
            for i in range(len(matrix)):
                for j in range(len(matrix[0])):
                    if matrix[i][j] == '1':
                        return 1
            
            return 0
            
        mx = 0
        has_one = 0
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                
                matrix[i][j] = int(matrix[i][j])
                if matrix[i][j] == 1:
                    has_one = 1
                
                if i == 0 or j == 0:
                    continue
                
                if matrix[i][j] == 1:
                    matrix[i][j] = 1 + min(matrix[i][j-1], matrix[i-1][j], matrix[i-1][j-1])
                    mx = max(mx, matrix[i][j])
        
        if mx == 0:
            return has_one
        
        return mx*mx
    
