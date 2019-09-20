/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // Date: 19-05-10
class Solution {
    private TreeNode pre;
    
    public boolean isValidBST(TreeNode root) {
        return isVRecur(root, null, null);
    }
    
    private boolean isVRecur(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        boolean l, r, c;
        l = r = c = false;
        
        l = isVRecur(root.left, min, root.val);
        c = (min == null || root.val > min) && (max == null || root.val < max);
        r = isVRecur(root.right, root.val, max);
        
        return l && c && r;
    }
    
    /*
    [], [1], [1,1], [1,null,1],   [2,1,3] [5,2,4,null,6]
    */
}