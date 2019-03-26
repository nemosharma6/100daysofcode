/* https://leetcode.com/problems/find-the-duplicate-number/ */
class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            curr = nums[i]
            if curr < 0:
                curr = -curr
                
            if nums[curr-1]<0:
                return curr
            else:
                nums[curr-1]=-nums[curr-1]
                
        return 0
