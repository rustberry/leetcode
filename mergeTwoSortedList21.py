class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        l3 = ListNode(0)
        ptr = l3
        while l1 is not None and l2 is not None:
            if l1.val <= l2.val:
                ptr.next = l1
                l1 = l1.next
            else:
                ptr.next = l2
                l2 = l2.next
            ptr = ptr.next
        
        if l1 is None:
            ptr.next = l2
        else:
            ptr.next = l1
            
        return l3.next
        
    def mergeTwoListsIterative(self, l1, l2):
        while l1 is not None and l2 is not None:
            if l1.val <= l2.val:
                l1.next = self.mergeTwoListsIterative(l1->next, l2)
                return l1
            else:
                l2.next = self.mergeTwoListsIterative(l1, l2->next)
                return l2

        if l1 is None:
            return l2
        else:
            return l1
            