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
    public int maxPathSum(TreeNode root) {
        return maxPathSumRecur(root)
    }
    
    private int maxPathSumRecur(TreeNode root) {
        if (root.val < 0) {
            int sl = maxPathSumRecur(root.left);
            int sr = maxPathSumRecur(root.right);
            if (sl >= sr) return sl;
            else return sr;
        }
        return root.val + maxPathSumRecur(root.left) + maxPathSumRecur(root.right)
    }
}