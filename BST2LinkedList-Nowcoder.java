class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

public class Solution {
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        TreeNode dummyHead = new TreeNode(0);
        sortToLast(pRootOfTree, dummyHead);
        dummyHead.right.left = null;
        return dummyHead.right;
    }
    
    public TreeNode sortToLast(TreeNode head, TreeNode prev) {
        TreeNode last = null;
        if (head.left == null) {
            prev.right = head;
            head.left = prev;
        } else {
            last = sortToLast(head.left, prev);
            last.right = head;
            head.left = last;
        }
        if (head.right == null) {
            if (last == null) {
                head.left = prev;
                prev.right = head;
            }
            return head;
        } else {
            return sortToLast(head.right, head);
        }
    }
}