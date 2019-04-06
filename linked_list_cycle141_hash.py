# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        runner = head
        history = dict()
        while runner is not None:
            if id(runner) in history:
                return True
            history[id(runner)] = runner.val
            runner = runner.next
        return False