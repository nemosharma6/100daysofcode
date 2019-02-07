# https://leetcode.com/problems/happy-number/

class Solution:
    def isHappy(self, n: 'int') -> 'bool':
        set_of_num = set()
        set_of_num.add(n)
        
        while True: 
            s = 0
            while n > 0:
                r = n % 10
                s = s + r*r
                n = int(n / 10)
            
            if s == 1:
                return True
            
            if s in set_of_num:
                return False
            
            n = s
            set_of_num.add(s)
            
        return True
