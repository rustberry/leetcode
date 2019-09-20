import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Iterator;

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
// FindPathNowcoder
public class Solution {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        Deque<Integer> stack = new ArrayDeque<>();
        findHelper(root, target, 0, stack);
        
        return ret;
    }
    
    private void findHelper(TreeNode root, int target, int ps, Deque<Integer> stack) {
        if (root == null) return;
        stack.push(root.val);
        if (root.val + ps == target && root.left == null && root.right == null) {
            ArrayList<Integer> hit = new ArrayList<>();
            Iterator<Integer> ite = stack.descendingIterator();
            while (ite.hasNext()) {
                int i = ite.next();
                hit.add(i);
            }
            ret.add(hit);
            stack.pop();
            return;
        }
        
        if (root.left != null) findHelper(root.left, target, ps + root.val, stack);
        if (root.right != null) findHelper(root.right, target, ps + root.val, stack);
        
        stack.pop();
    }
}