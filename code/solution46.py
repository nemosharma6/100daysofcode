# https://leetcode.com/problems/hamming-distance/
class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        c = 0
        while x!=0 or y!=0:
            r1 = x & 1
            r2 = y & 1
            if r1 != r2:
                c += 1
            x = x >> 1
            y = y >> 1
        
        return c
