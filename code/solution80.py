# https://leetcode.com/problems/house-robber/
class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        
        if len(nums) == 1:
            return nums[0]
        
        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        dp=[]
        sol=0
        for i in range(len(nums)):
            sol=max(sol,nums[i])
            dp.append(0)
            
        dp[0]=nums[0]
        dp[1]=nums[1]
        for i in range(2, len(nums)):
            for j in range(0,i-1):
                dp[i]=max(dp[i], dp[j]+nums[i])
            sol=max(dp[i],sol)
        
        return sol
