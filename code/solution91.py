# https://leetcode.com/problems/linked-list-cycle/
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        h1=head
        if h1 is None:
            return False
        
        h2=h1.next
        if h2 is None:
            return False
        
        h2=h2.next
        if h2 is None:
            return False
        
        while h1 != h2:
            h1=h1.next
            h2=h2.next
            if h2 is None or h1 is None:
                return False
            
            h2=h2.next
            if h2 is None:
                return False

        return True
        
