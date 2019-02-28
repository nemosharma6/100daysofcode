# https://leetcode.com/problems/unique-binary-search-trees/
class Solution:
    def numTrees(self, n: int) -> int:
        if n == 0 or n == 1:
            return n
        
        return self.catalan_number(n)
        
    
    def catalan_number(self, n: int) -> int:
        c = 1
        pr = 1
        
        for i in range(n+2, 2*n+1):
            pr = pr * i
            c = c * (i-n-1)    
        
        c = c*n
        return int(pr / c)
