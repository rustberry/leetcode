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
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversal_2stack(root);
    }
    
    // Use only one stack
    public List<Integer> postorderTraversal_1stack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        TreeNode tmp = null;
        while (!stack.isEmpty() || !root == null) {
            while (root != null) {
                if (root.right != null) stack.push(root.right);
                stack.push(root);
                root = root.left;
            }
            // if (root == null) {
            root = stack.pop();
            if (root.right != null && root.right == stack.peek()) {
                stack.pop();
                stack.push(root);
                root = root.right;
            } else {
                res.add(root.val);
            }
            // }
        }
    }
    
    public List<Integer> postorderTraversal_2stack(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> postStack = new LinkedList<>(), tmpStack = new ArrayDeque<>();
        while (root != null || !tmpStack.isEmpty()) {
            if (root != null) {
                postStack.push(root);
                if (root.left != null) tmpStack.push(root.left);
                // if (root.right != null) postStack.push(root.right);
                root = root.right;
            } else {
                root = tmpStack.pop();
            }
        }
        while (!postStack.isEmpty()) {
            res.add(postStack.pop().val);
        }
        return res;
    }
}