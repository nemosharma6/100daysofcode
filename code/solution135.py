# https://leetcode.com/problems/check-completeness-of-a-binary-tree/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isCompleteTree(self, root: TreeNode) -> bool:
        if root is None or (root.left is None and root.right is None):
            return True
        
        level=self.getLevel(root)
        li=[]
        self.lastLevel(root,0,level-1,li)
        for i in range(len(li)-1):
            if li[i] is None and li[i+1] is not None:
                return False
            
        return self.twoChild(root,0,level-2)
    
    def getLevel(self, root: TreeNode):
        if root is None:
            return 0
        return 1 + max(self.getLevel(root.left), self.getLevel(root.right))
        
    def twoChild(self, root: TreeNode, l, last):
        if root is None:
            return False
        
        if l<last and (root.left is None or root.right is None):
            return False
        
        if l==last:
            return True
        
        return self.twoChild(root.left, l+1, last) and self.twoChild(root.right, l+1, last)
    
    def lastLevel(self, root, l, last, li):
        if l==last:
            li.append(root)
            return
        
        if root is not None:
            self.lastLevel(root.left, l+1, last, li)
            self.lastLevel(root.right, l+1, last, li)
