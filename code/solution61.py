# https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        if root is None:
            return None
        
        if (root.left == p and root.right == q) or (root.right == p and root.left == q):
            return root
        
        l = self.lowestCommonAncestor(root.left, p, q)
        r = self.lowestCommonAncestor(root.right, p, q)
        
        if (l==p and r==q) or ((l==p or r==p) and root==q) or ((l==q or r==q) and root==p):
            return root
        
        if l==q and r==p:
            return root
        
        if l == p or l == q:
            return l
        
        if r == q or r == p:
            return r
        
        if l != p and l is not None:
            return l
        
        if r != q and r is not None:
            return r
        
        if root == p or root == q:
            return root
        
        return None
        
