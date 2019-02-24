# Definition for a binary tree node.
# https://leetcode.com/problems/convert-bst-to-greater-tree/
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def helper(self, root: TreeNode, s: int) -> int:
        if root is None:
            return 0
        
        if root.left is None and root.right is None:
            root.val = root.val + s
            return root.val
        
        r = 0
        if root.right is not None:
            r = self.helper(root.right, s)
        else:
            r = s
            
        root.val = root.val + r
        
        l = 0
        if root.left is not None:
            l = self.helper(root.left, root.val)
        else:
            l = root.val
            
        return l
    
    def convertBST(self, root: TreeNode) -> TreeNode:
        self.helper(root, 0)
        return root
