# https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
class Solution:
    def findMin(self, nums: List[int]) -> int:
        pivot = self.find_pivot(nums)
        return nums[pivot+1]
        
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
