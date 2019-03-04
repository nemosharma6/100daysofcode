# https://leetcode.com/problems/minimum-path-sum/

class Solution(object):
    def minPathSum(self, grid):
        
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                
                if i == 0 and j == 0:
                    continue
                
                if i == 0:
                    grid[i][j] += grid[i][j-1]
                
                if j == 0:
                    grid[i][j] += grid[i-1][j]
                    
                if i>0 and j>0:
                    grid[i][j] += min(grid[i-1][j], grid[i][j-1])
        
        return grid[len(grid)-1][len(grid[0])-1]
