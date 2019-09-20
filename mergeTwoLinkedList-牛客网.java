/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode dummyHead = new ListNode(0);
        ListNode w1 = list1;
        ListNode w2 = list2;
        ListNode head = dummyHead;

        while (w1 != null && w2 != null) {
            if (w1.val < w2.val) {
                head.next = w1;
                
                head = head.next;
                w1 = w1.next;
            } else {
                head.next = w2;
                
                head = head.next;
                w2 = w2.next;
            }
        }
        
        if (w1 != null) {
            head.next = w1;
        } else if (w2 != null) {
            head.next = w2;
        }
        
        return dummyHead.next;
    }
}