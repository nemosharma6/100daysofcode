# https://leetcode.com/problems/search-in-rotated-sorted-array/
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        pivot = self.find_pivot(nums)
        
        if pivot == -1:
            return self.find(nums,0,len(nums)-1,target)
        
        if target == nums[pivot]:
            return pivot
        
        if target>=nums[0]:
            return self.find(nums,0,pivot,target)
        
        return self.find(nums,pivot+1,len(nums)-1,target)
    
    def find_pivot(self, nums: List[int]):
        l=0
        r=len(nums)-1
        
        while l<=r:
            m=int((l+r)/2)
            if m<len(nums)-1 and nums[m]>nums[m+1]:
                return m
            
            if nums[m]>=nums[0]:
                l=m+1
            else:
                r=m-1
            
        return -1
    
    def find(self, nums: List[int], s, e, target):
        
        while s<=e:
            m=int((s+e)/2)
            if nums[m] == target:
                return m
            
            if nums[m]>target:
                e=m-1
            else:
                s=m+1
                
        return -1
        
