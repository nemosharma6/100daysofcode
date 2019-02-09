# https://leetcode.com/problems/basic-calculator-ii/
# TO-DO improvements - could do better than regex and reduce to a single iteration

class Solution:
    def calculate(self, s: 'str') -> 'int':
        nums = re.findall("\d+", s)
        ops = re.findall("[+-/*]", s)
        
        if len(ops) == 0:
            return int(nums[0])
        
        for j in range(len(nums)):
            nums[j] = int(nums[j])
        
        i = 0
        while True:
                
            if i == len(ops):
                break;
                
            match = False
            if ops[i] == '/':
                temp = int(nums[i] / nums[i+1])
                match = True
            elif ops[i] == '*':
                temp = int(nums[i] * nums[i+1])
                match = True
                
            if match == True:
                nums[i] = temp
                del nums[i+1]
                del ops[i]
                i = i - 1
                    
            i = i + 1
                    
            if len(nums) == 1:
                print(nums[0])
                return int(nums[0])
        
        i = 0
        while True:
                
            if i == len(ops):
                break;
                
            match = False
            if ops[i] == '+':
                temp = nums[i] + nums[i+1]
                match = True
            elif ops[i] == '-':
                temp = nums[i] - nums[i+1]
                match = True
                
            if match == True:
                nums[i] = temp
                del nums[i+1]
                del ops[i]
                i = i - 1
                    
            i = i + 1
                    
            if len(nums) == 1:
                print(nums[0])
                return int(nums[0])
        
        return 0
    
    
