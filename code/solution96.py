# https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def verticalTraversal(self, root: TreeNode) -> List[List[int]]:
        d={}
        self.traverse(root, 0, d, 0)
        
        for i in d.keys():
            tmp=list(dict(sorted(d[i].items())).values())
            d[i]=[item for sublist in tmp for item in sublist]
            
        return list(dict(sorted(d.items())).values())
        
    def traverse(self, node: TreeNode, num: int, l, d):
        
        if node is None:
            return
        
        if num not in l:
            l[num]=dict()
            
        if d not in l[num]:
            l[num][d]=list()
            
        l[num][d].append(node.val)
        l[num][d].sort()
        self.traverse(node.left, num-1, l, d+1)
        self.traverse(node.right, num+1, l, d+1)
