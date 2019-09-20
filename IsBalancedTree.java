public class Solution {
    private int left = 0;
    private int right = 0;
    // 
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        
        if (isBalanced(root.left, true)) {
            int leftLen = left;
            if (isBalanced(root.right, false)) {
                left = leftLen;
                if (Math.abs(left - right) > 1) return false;
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isBalanced(TreeNode root, boolean isLeft) {
        if (root == null) {
            left = isLeft ? 0 : left;
            right = isLeft ? right : 0;
            return true;
        }
        
        if (isBalanced(root.left, true)) {
            int leftLen = left;
            if (isBalanced(root.right, false)) {
                left = leftLen;
                int diff = Math.abs(left - right);
                if (diff > 1) return false;
                
                int h = (left > right) ? left : right;
                h++;
                left = isLeft ? h : left;
                right = isLeft ? right : h;
                return true;
            }
        }
        
        return false;        
    }
    
    // public int getheight(TreeNode root) {
        // if (root == null) return 0;
        // int left = getheight(root.left);
        // int right = getheight(root.right);
        // return (left > right) ? left : right;
    // }
}