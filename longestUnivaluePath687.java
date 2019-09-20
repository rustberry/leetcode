/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * Given a binary tree, find the length of the longest path
 * where each node in the path has the same value.
 * This path may or may not pass through the root.
 */
// Date: 19-05-08
  
class Solution {
    private int ret;
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> prog = new ArrayDeque<>();
        prog.push(root);
        while (!prog.isEmpty()) {
            TreeNode w = prog.pop();
            int newS = univalPath(w.right, w.val, 0, prog) + univalPath(w.left, w.val, 0, prog);
            this.ret = this.ret < newS ? newS : this.ret;
        }
        
        return this.ret;
    }
    
    private int univalPath(TreeNode root, int paraV, int pathS, Deque<TreeNode> prog) {
        if (root == null) {
            return 0;
        }
        
        if (root.val != paraV) {
            // if (root.left != null) {
                // prog.push(root.left);
            // }
            // if (root.right != null) {
                // prog.push(root.right);
            // }
            prog.push(root);
            return 0;
        }

        return 1 + univalPath(root.left, paraV, pathS+1, prog) + univalPath(root.right, paraV, pathS+1, prog);
    }
}