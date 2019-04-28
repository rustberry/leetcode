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
    private List<String> ret = new ArrayList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return ret;
        String path = root.val + "";
        if (root.left == null && root.right == null) {
            ret.add(path);
            return ret;
        }
        btPathRecur(root.left, path);
        btPathRecur(root.right, path);
        return ret;
    }
    
    // f(nodeLeaf): add to ret
    private void btPathRecur(TreeNode root, String path) {
        if (root == null) return;
        String p = path + "->" + root.val;
        if (root.left == null && root.right == null) {
            this.ret.add(p);
            return;
        }
        btPathRecur(root.left, p);
        btPathRecur(root.right, p);
    }
}