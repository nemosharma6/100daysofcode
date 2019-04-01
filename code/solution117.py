/* https://leetcode.com/problems/unique-paths-iii/ */
class Solution:
    si,sj,ei,ej,cool=0,0,0,0,0
    def uniquePathsIII(self, grid: List[List[int]]) -> int:
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]==1:
                    self.si,self.sj=i,j
                elif grid[i][j]==2:
                    self.ei,self.ej=i,j
                elif grid[i][j]==0:
                    self.cool+=1
                  
        v=[]
        for i in range(len(grid)):
            t=[]
            for j in range(len(grid[0])):
                t.append(False)
            v.append(t)
            
        return self.dfs(grid,self.si,self.sj,v,0)
    
    def dfs(self,g,i,j,v,l):
        if i==self.ei and j==self.ej:
            if l==self.cool+1:
                return 1
            else:
                return 0
           
        if i<0 or j<0 or i==len(g) or j==len(g[0]) or v[i][j]==True or g[i][j]==-1:
            return 0
        
        c=0
        v[i][j]=True
        c+=self.dfs(g,i+1,j,v,l+1)
        c+=self.dfs(g,i,j+1,v,l+1)
        c+=self.dfs(g,i-1,j,v,l+1)
        c+=self.dfs(g,i,j-1,v,l+1)
        v[i][j]=False
        
        return c
