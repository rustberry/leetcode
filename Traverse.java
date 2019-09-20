public class Traverse {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int v) {
            val = v;
        }
    }
    
    public void preOrderIter(Node root) {
        if (root == null) return;
        Deque<Node> td = new ArrayDeque<>();
        td.push(root);
        while (!td.isEmpty()) {
            Node w = td.pop();
            System.out.println(w);
            if (w.left != null) td.push(w.left);
            if (w.right != null) td.push(w.right);
        }
    }
    
    public void postOrderIter(Node root) {
        if (root == null) return;
        Deque<Node> wd = new ArrayDeque<>();
        Deque<Node> res = new ArrayDeque<>();
        wd.push(root);
        while (!wd.isEmpty()) {
            Node w = wd.pop();
            res.push(w);
            if (w.right != null) wd.push(w.right);
            if (w.left != null) wd.push(w.left);
        }
        while (!res.isEmpty() {
            Node n = res.pop();
            System.out.println(n.val);
        }
    }
}