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
    public boolean hasPathSum(TreeNode root, int sum) {
        return hasPathSum1(root.left, sum, root.val) || hasPathSum1(root.right, sum, root.val);
        return hasPathSum2(root, sum);
        return hasPathSum2_recursive(root, sum);
    }
    
    private boolean hasPathSum2_recursive(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.val == sum) return true;
        }
        if (root.left != null) {
            root.left.val += root.val;
        }
        if (root.right != null) {
            root.right.val += root.val;
        }
        return hasPathSum2_recursive(root.left, sum) || hasPathSum2_recursive(root.right, sum);
    }
    
    private boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;
        
        Deque<TreeNode> ts = new ArrayDeque<>();
        ts.push(root);
        while (!ts.isEmpty()) {
            TreeNode walker = ts.pop();
            if (walker.left == null && walker.right == null) {
                if (walker.val == sum) return true;
            }
            if (walker.left != null) {
                walker.left.val += walker.val;
                ts.push(walker.left);
            }
            if (walker.right != null) {
                walker.right.val += walker.val;
                ts.push(walker.right);
            }
            
        }
        return false;
    }
    
    // f(root) = f(root.left) || f(root.right)
    // f(nodeLeaf) && s == sum return true
    private boolean hasPathSum1(TreeNode root, int sum, int ps) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val + ps == sum;
        return hasPathSum1(root.left, sum, root.val+ps) || hasPathSum1(root.right, sum, root.val+ps);
    }
}