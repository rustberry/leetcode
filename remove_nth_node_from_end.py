# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        slow, fast = head, head
        length = 1
        if fast.next is None:
            return None
        
        while fast.next is not None:
            slow = slow.next
            fast = fast.next
            length += 1
            if fast.next is None:
                break
            fast = fast.next
            length += 1
        n = length - n + 1  # the Nth from end -> the Nth from head
        cur, pre = head.next, head
        count = 1
        if n == 1:
            return head.next
        else:
            count += 1
            
        # if length > 5 and n > length / 2:
            # cur, pre = slow.next, slow
            # if odd:
                # count += (length / 2 - 1)
            # else:
                # count += (length / 2 )
        while count != n:
            cur = cur.next
            pre = pre.next
            count += 1
            
        pre.next = cur.next
        return head