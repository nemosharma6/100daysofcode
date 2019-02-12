# https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution:
    def firstUniqChar(self, s: 'str') -> 'int':
        mp = {}
        
        for i in range(len(s)):
            if s[i] in mp.keys():
                mp[s[i]] = math.inf;
            else:
                mp[s[i]] = i
              
        mn = math.inf
        for i in mp.keys():
            if mn > mp[i]:
                mn = mp[i]
                break
        
        if mn == math.inf:
            return -1
        
        return mn
