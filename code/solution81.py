# https://leetcode.com/problems/house-robber-ii/
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        
        if len(nums) == 1:
            return nums[0]
        
        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        dp1,dp2 = [],[]
        sol=0
        for i in range(len(nums)-1):
            sol=max(sol,nums[i])
            dp1.append(0)
            dp2.append(0)
            
        sol=max(sol, nums[-1])
        
        dp1[0]=nums[0]
        dp1[1]=nums[1]
        for i in range(2, len(nums)-1):
            for j in range(0,i-1):
                dp1[i]=max(dp1[i], dp1[j]+nums[i])
            sol=max(dp1[i],sol)
        
        dp2[0]=nums[1]
        dp2[1]=nums[2]
        for i in range(3, len(nums)):
            for j in range(0,i-2):
                dp2[i-1]=max(dp2[i-1], dp2[j]+nums[i])
            sol=max(dp2[i-1],sol)
        
        return sol
