# https://leetcode.com/problems/binary-tree-maximum-path-sum/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    mx = -sys.maxsize
    
    def helper(self, root: TreeNode) -> int:
        if root is None:
            return 0
        
        l = self.helper(root.left)
        r = self.helper(root.right)
        ret = max(l, r)
        if root.val + l + r > self.mx:
            self.mx = root.val + l + r
            
        if root.val > self.mx:
            self.mx = root.val
            
        if ret + root.val > self.mx:
            self.mx = ret + root.val
        
        return max(root.val, ret + root.val)
    
    def maxPathSum(self, root: TreeNode) -> int:
        self.helper(root)
        return self.mx
