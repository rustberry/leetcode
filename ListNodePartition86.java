/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// medium
class Solution {
    // [],3 [1],3 [1,2],3;  [4,5,3,6,1,2],3
    public ListNode partition(ListNode head, int x) {
        ListNode dummyH = new ListNode(0);
        dummyH.next = head;
        ListNode preLess = dummyH, walker = dummyH;
        
        while (preLess.next != null && walker.next != null) {
            if (walker.next.val >= x) {
                preLess = walker;
                while (preLess.next.val >= x) {
                    preLess = preLess.next;
                    if (preLess.next == null) return dummyH.next;
                }
                ListNode temp = walker.next;
                walker.next = preLess.next;  // link the small node to left
                preLess.next = preLess.next.next;  // remove the small node
                walker.next.next = temp;  // finish insertion
                walker = walker.next;
            } else {
                walker = walker.next;
            }
        }
        
        return dummyH.next;
    }
}