/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class PrintLinkedListReversely {
    private ArrayList<Integer> res = new ArrayList<>();
    
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        // return printListFromTailToHead1(listNode);
        if (listNode == null) return res;
        return printListFromTailToHead2(listNode);
    }
    
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode.next != null) printListFromTailToHead2(listNode.next);
        res.add(listNode.val);
        return res;
    }
    
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Deque<ListNode> ld = new LinkedList<>();
        while (listNode != null) {
            ld.push(listNode);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>(ld.size());
        while (!ld.isEmpty()) {
            ListNode n = ld.pop();
            res.add(n.val);
        }
        
        return res;
    }
}