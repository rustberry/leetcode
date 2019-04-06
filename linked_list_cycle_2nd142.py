# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        runner = head
        history = dict()
        id_num = 0
        while runner is not None:
            id_num = id(runner)
            if id_num in history:
                return runner
            history[id_num] = 1
            runner = runner.next
        return None