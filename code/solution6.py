# https://leetcode.com/problems/count-primes/

class Solution:
    def countPrimes(self, n: 'int') -> 'int':
        
        if n == 1 or n == 0:
            return 0
        
        ar = [True] * n
        
        for i in range(2, int(math.sqrt(n)) + 1):
            j = i
            if ar[i] == True:
                while i*j < n:
                    ar[i*j] = False
                    j = j + 1
        
        c = 0
        for i in range(2, n):
            if ar[i] == True:
                c = c + 1
                
        return c