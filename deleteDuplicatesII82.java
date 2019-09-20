/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // [] [1]; [1,1,1,1] [1,1,2] [1,2,3,3,3,3]; [1,2,3,3,4,4,3,5]
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode walker = head;
        ListNode pre;
        while (walker.next != null) {
            if (walker.next.val == walker.val) {
                walker.next = walker.next.next;
                // when dups are at tail
                if (walker.next != null) {
                    if (walker.next.val != walker.val) { // if not, delete current
                        walker.val = walker.next.val;
                        walker.next = walker.next.next;
                    }
                } else {
                    if (pre != null) pre.next = walker.next;
                    else return null;    // the whole list is duplicate
                }
            } else {
                pre = walker;
                walker = walker.next;
            }
        }
        return head;
    }
}