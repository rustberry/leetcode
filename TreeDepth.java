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
// Note the follow up of this: "check if is valid binary search tree"

public class Solution {
    // private int left = 0;
    // private int right = 0;
    
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int l = getHeight(root.left, 0);
        int r = getHeight(root.right, 0);
        return (l > r) ? (l + 1) : (r + 1);
    }
    
    public int getHeight(TreeNode root, int cur) {
        if (root == null) return 0;
        
        int left = getHeight(root.left, cur);
        int right = getHeight(root.right, cur);
        
        int h = (left > right) ? (left + 1) : (right + 1);
        return h;
    }
}