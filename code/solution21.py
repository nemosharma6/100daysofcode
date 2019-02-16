# https://leetcode.com/problems/palindrome-partitioning/

class Solution:
    
    def compute(self, s, k, li, ar, sol):
        
        if k == len(s):
            print(li)
            sol.append(list(li))
            return
        
        for i in range(k, len(s)):
            if ar[k][i] == True:
                li.append(s[k:i+1])
                self.compute(s, i+1, li, ar, sol)
                li.pop()
                
    def partition(self, s: 'str') -> 'List[List[str]]':
        
        if len(s) == 0 or len(s) == 1:
            sol = []
            sol.append(list(s))
            return sol
        
        ar = []
        for i in range(len(s)):
            a=[]
            for j in range(len(s)):
                a.append(False)
            ar.append(a)
            
        for i in range(len(s)-1, -1, -1):
            for j in range(i, len(s)):
                if i == j:
                    ar[i][j] = True
                    continue
                
                if s[i] == s[j] and j-i == 1:
                    ar[i][j] = True
                    continue
                    
                if s[i] == s[j] and ar[i+1][j-1] == True:
                    ar[i][j] = True
        
        sol = []
        self.compute(s, 0, [], ar, sol)
        return sol
        
        