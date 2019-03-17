# https://leetcode.com/problems/spiral-matrix/
class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
    
        if matrix is None or len(matrix)==0 or len(matrix[0])==0:
            return []
        
        sol=[]
        m=len(matrix)
        n=len(matrix[0])
        
        rs=0
        re=m-1
        cs=0
        ce=n-1
        
        while rs<=re and cs<=ce:
            
            for i in range(cs,ce+1):
                sol.append(matrix[rs][i])
            rs+=1
            
            for i in range(rs,re+1):
                sol.append(matrix[i][ce])
            ce-=1
            
            if rs<=re:
                for i in range(ce,cs-1,-1):
                    sol.append(matrix[re][i])
            re-=1
            
            if cs<=ce:
                for i in range(re,rs-1,-1):
                    sol.append(matrix[i][cs])
            cs+=1
        
        return sol
