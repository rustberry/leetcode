# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        l3 = ListNode(0)
        ptr = l3
        carry = 0
        while l1 is not None and l2 is not None:
            sum = l1.val + l2.val + carry
            if sum > 9:
                sum -= 10
                ptr.next = ListNode(sum)
                carry = 1
            else:
                ptr.next = ListNode(sum)
                carry = 0
            ptr = ptr.next
            l1 = l1.next
            l2 = l2.next
        
        while carry == 1:
            if l1 is None and l2 is None:
                ptr.next = ListNode(1)
                ptr = ptr.next
                break
            elif l1 is None:
                l2.val += 1
                carry = 0
                ptr.next = l2
                if l2.val > 9:
                    l2.val -= 10
                    carry = 1
                    l2 = l2.next
                    ptr = ptr.next
            else:
                l1.val += 1
                carry = 0
                ptr.next = l1
                if l1.val > 9:
                    l1.val -= 10
                    carry = 1
                    l1 = l1.next
                    ptr = ptr.next
                    
        if l1 is None:
            ptr.next = l2
        else:
            ptr.next = l1
        return l3.next
        
"""
[8,9,9]
[2]
"""