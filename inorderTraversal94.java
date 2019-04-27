/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode walker = root;
        while (walker != null || !stack.isEmpty()) {
            if (walker != null) {
                stack.push(walker);
                walker = walker.left;
            } else {
                walker = stack.pop();
                ret.add(walker.val);
                walker = walker.right;
            }
        }
        
        return ret;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Recursive {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<>();
        if (root == null) { return ret; }
        inT(ret, root);
        return ret;
    }
    
    public void inT(List<Integer> l, TreeNode root) {
        if (root == null) {
            return;
        }
        inT(l, root.left);
        l.add(root.val);
        inT(l, root.right);
    }
}