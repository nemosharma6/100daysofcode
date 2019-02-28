# https://leetcode.com/problems/symmetric-tree/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root is None:
            return True
        
        return self.helper(root.left, root.right)
    
    def helper(self, root1: TreeNode, root2: TreeNode) -> bool:
        if root1 is None and root2 is None:
            return True
        
        if root1 is None:
            return False
        
        if root2 is None:
            return False
        
        if root1.val != root2.val:
            return False
        
        a = self.helper(root1.left, root2.right)
        b = self.helper(root2.left, root1.right)
        
        return a & b
