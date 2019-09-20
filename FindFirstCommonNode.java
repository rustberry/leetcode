/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        return firstCommonWithStack(pHead1, pHead2);
    }
    
    public ListNode firstCommonWithStack(ListNode h1, ListNode h2) {
        Deque<ListNode> s1 = new LinkedList<>(), s2 = new LinkedList<>();
        
        while (h1 != null) {
            s1.push(h1);
            h1 = h1.next;
        }
        
        while (h2 != null) {
            s2.push(h2);
            h2 = h2.next;
        }
        
        ListNode l1 = s1.peek();
        ListNode l2 = s2.peek();
        
        while (s1.pop() == s2.pop()) {
            l1 = s1.peek();
            l2 = s2.peek();
        }
        
        return l2;
    }
}