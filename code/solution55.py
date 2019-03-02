# https://leetcode.com/problems/remove-nth-node-from-end-of-list/
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        second_head = head
        for i in range(0, n):
            second_head = second_head.next
            
        prev = None
        tmp = head
        while second_head is not None:
            prev = tmp
            tmp = tmp.next
            second_head = second_head.next
            
        if prev is None:
            return tmp.next
        
        prev.next = tmp.next
        return head
