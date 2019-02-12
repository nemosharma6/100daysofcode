# https://leetcode.com/problems/partition-equal-subset-sum/

class Solution:
    def canPartition(self, nums: 'List[int]') -> 'bool':
        s = 0
        for i in nums:
            s = s + i
            
        if s % 2 != 0:
            return False
        
        dp = []
        for i in range(1+int(s/2)):
            t = []
            for j in range(1+len(nums)):
                t.append(False)
            dp.append(t) 
            
        for i in range(1+len(nums)):
            dp[0][i] = True
            
        for i in range(1+int(s/2)):
            for j in range(1, len(nums)+1):
                dp[i][j] = dp[i][j-1]
                if i >= nums[j-1]:
                    dp[i][j] = dp[i][j] or dp[i-nums[j-1]][j-1]
        
        return dp[int(s/2)][len(nums)]
