/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode walker = head;
        // loop invariant
        while (walker.next != null) {
            if (walker.next.val == walker.val) {
                walker.next = walker.next.next;
            } else {
                walker = walker.next;
            }
        }
        return head;
    }
}