# https://leetcode.com/problems/jump-game/
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        
        if len(nums) == 0:
            return True
        
        l = []
        l.append(True)
        for i in range(1, len(nums)):
            l.append(False)
            
        for i in range(0, len(nums)):
            for j in range(i-1, -1, -1):
                if l[j] is True and nums[j]+j >= i:
                    l[i] = True
                    break
                
            if l[i] is False:
                return False
        
        return True
