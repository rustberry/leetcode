# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def middleNode(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        l = r = head
        while r.next is not None:
            l = l.next
            r = r.next
            if r.next is None:
                break
            else:
                r = r.next
        
        return l