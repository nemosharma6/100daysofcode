# https://leetcode.com/problems/sum-of-left-leaves/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def helper(self, root: TreeNode, ind: int):
        
        if root is None:
            return 0
        
        if root.left is None and root.right is None and ind == -1:
            return root.val
        
        l = self.helper(root.left, -1)
        r = self.helper(root.right, 1)
        return l+r
    
    def sumOfLeftLeaves(self, root: TreeNode) -> int:
        return self.helper(root, 0)
        
