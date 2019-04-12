# https://leetcode.com/problems/longest-turbulent-subarray/
class Solution:
    def maxTurbulenceSize(self, A: List[int]) -> int:
        mx,i1,i2,c1,c2=1,0,0,1,1
        for i in range(0,len(A)-1):
            if i1==0 and A[i]<A[i+1]:
                i1,c1=1,c1+1
            elif i1==1 and A[i]>A[i+1]:
                i1,c1=0,c1+1
            else:
                i1,c1=0,1
                if i1==0 and A[i]<A[i+1]:
                    i1,c1=1,c1+1
                    
            if i2==0 and A[i]>A[i+1]:
                i2,c2=1,c2+1
            elif i2==1 and A[i]<A[i+1]:
                i2,c2=0,c2+1
            else:
                i2,c2=0,1
                if i2==0 and A[i]>A[i+1]:
                    i2,c2=1,c2+1
            
            mx=max(mx,max(c1,c2))
        
        return mx
