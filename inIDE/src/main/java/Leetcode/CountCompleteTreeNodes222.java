package Leetcode;

public class CountCompleteTreeNodes222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int hl = 1, hr = 1;
        TreeNode left = root.left, right = root.right;
        while (left != null) {hl++; left = left.left;}
        while (right != null) {hr++; right = right.right;}
        if (hl == hr) return (int) (Math.pow(2, hl) - 1);
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
