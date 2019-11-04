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
    private TreeNode par;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return rec(root, p, q);
    }
    
    private TreeNode rec(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) {
            if (rec(root.left, p, q) != null
                || rec(root.right, p, q) != null) {
                    par = root;
                    return null;
            } else {
                return root;
            }
        }
        TreeNode left = rec(root.left, p, q);
        TreeNode right = rec(root.right, p, q);
        if (left != null && right != null) {
            par = root;
            return null;
        }
        if (left == null) return right;
        return left;
    }
}