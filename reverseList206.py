# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummyH = ListNode(0)
        dummyH.next = head
        preC = dummyH
        cur = head
        sentinel = None
        print('preC, cur', preC.val, cur.val)
        print('head', head, 'head.val', head.val)
        while sentinel != dummyH.next:

            while cur.next != sentinel:
                preC.next = cur.next
                cur.next = cur.next.next
                preC.next.next = cur
                
                preC = preC.next
                print('preC.val', preC.val, 'cur.val', cur.val)
            sentinel = cur
            cur = dummyH.next
            preC = dummyH
            print('sentinel', sentinel.val, 'cur', cur.val, 'preC', preC.val)
            print('head', head, 'head.val', head.val)
            print('dummyH.next', dummyH.next)
        return dummyH.next