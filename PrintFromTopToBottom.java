import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
*/

// Print a binary tree level by level, from left to right
public class Solution {
    private ArrayList<Integer> res = new ArrayList<>();
    
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) return res;
        Queue<TreeNode> tq = new ArrayDeque<>();
        TreeNode w = root;
        tq.add(root);
        while (!tq.isEmpty()) {
            // while (!tq.isEmpty()) {
            w = tq.poll();
            if (w == null) break;
            res.add(w.val);
            // }
            
            if (w.left != null) tq.add(w.left);
            if (w.right != null) tq.add(w.right);
        }
        
        return res;
    }
    
    // private void PrintFromTopToBottom1(TreeNode root) {
        // if (root == null) return null;
        // res.add(root.val);
    // }
}