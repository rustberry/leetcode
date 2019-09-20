// import java.util.LinkedList;

public class JosephusProb {
    public static class Node {
        int val;
        Node next;
        Node(int v) {
            this.val = v;
            this.next = null;
        }
    }
    
    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0) return -1;
            
        Node head = new Node(0);
        // Node.next = new Node(1);
        Node w = head;
        for (int i = 1; i < n; i++) {
            w.next = new Node(i);
            w = w.next;
        }
        w.next = head;  // circle
        
        int cnt = 0;
        w = head;
        while (w.next.val != w.val) {
            // pList(w);
            
            for (; cnt < m - 1; cnt++) {
                w = w.next;
            }
            w.val = w.next.val;  // delete the fifth one
            w.next = w.next.next;
            cnt = 0;
        }
        
        return w.val;
    }
    
    public static void main(String[] args) {
        int ret = new Solution().LastRemaining_Solution(5, 3);
        System.out.println("ret " + ret);
    }
    
    public void pList(Node head) {
        Node w = head.next;
        int stop = head.val;
        System.out.println("===== List");
        System.out.print(stop + " ");
        while (w.val != stop) {
            System.out.print(w.val+" ");
            w = w.next;
        }
        System.out.println();
    }
}