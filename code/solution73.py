# https://leetcode.com/problems/count-of-smaller-numbers-after-self/
class Solution:
    def countSmaller(self, nums: 'List[int]') -> 'List[int]':
        ar,ind = [],[]
        for i in range(len(nums)):
            ar.append(0)
            ind.append(i)
        
        self.inversion(nums,0,len(nums)-1,ind,ar)
        return ar
        
    def inversion(self, nums:'List[int]', l, r, ind: 'List[int]', ar):
        if l<r:
            m = int((l+r)/2)
            self.inversion(nums,l,m,ind,ar)
            self.inversion(nums,m+1,r,ind,ar)
            self.merge(nums,l,m,r,ind,ar)
            
    def merge(self, nums, l, m, r, ind, ar):
        n1=m-l+1
        n2=r-m
        
        a1,a2,i1,i2=[],[],[],[]
        for i in range(n1):
            a1.append(nums[l+i])
            i1.append(ind[l+i])
            
        for i in range(n2):
            a2.append(nums[m+1+i])
            i2.append(ind[m+1+i])
        
        i=j=0
        k=l
        
        while i<n1 and j<n2:
            if a1[i]>a2[j]:
                ar[i1[i]] += n2-j
                nums[k] = a1[i]
                ind[k] = i1[i]
                i+=1
            else:
                nums[k] = a2[j] 
                ind[k] = i2[j]
                j+=1
            k+=1
            
        while i < n1: 
            nums[k] = a1[i]; 
            ind[k] = i1[i];
            i+=1; 
            k+=1; 
  
        while j < n2: 
            nums[k] = a2[j]; 
            ind[k] = i2[j];
            j+=1; 
            k+=1;
