# https://leetcode.com/problems/reverse-linked-list/
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        
        tmp = head
        prev = None
        while tmp is not None:
            nxt = tmp.next
            tmp.next = prev
            prev = tmp
            tmp = nxt
            
        return prev
