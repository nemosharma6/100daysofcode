# https://leetcode.com/problems/valid-palindrome/

import re
class Solution:
    def isPalindrome(self, s: str) -> bool:
        ar = re.findall("\w", s)
        data = [k.lower() for k in ar]
        
        for i in range(int(len(ar)/2)):
            if data[i] != data[-1-i]:
                return False
            
        return True
