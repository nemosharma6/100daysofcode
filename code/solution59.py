# https://leetcode.com/problems/linked-list-cycle-ii/
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        
        if head is None:
            return None
        
        initial = True
        slow = head
        fast = head
        
        while slow != fast or initial is True:
            initial = False
            slow = slow.next
            tmp = fast.next
            
            if tmp is None or slow is None:
                return None
            
            fast = tmp.next
            if fast is None:
                return None
    
        tmp = head
        while tmp != slow:
            tmp = tmp.next
            slow = slow.next
        
        return tmp
        
        
