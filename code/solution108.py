# https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        tmp=list(nums)
        tmp.sort()
        i=0
        j=len(nums)-1
        while i<len(nums) and tmp[i]==nums[i]:
            i+=1
            
        while j>=0 and nums[j]==tmp[j]:
            j-=1
        
        return max(j-i+1, 0)
