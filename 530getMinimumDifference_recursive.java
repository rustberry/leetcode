// public class TreeNode {
    // int val;
    // TreeNode left;
    // TreeNode right;
    // TreeNode(int x) { val = x; }
// }

class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
        if (root == null) {
            return;
        }
        traverse(root.left);
        // min = Math.min(min, root.val - pre.val);
        return root.val;
        traverse(root.right);
    }
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        
        getMinimumDifference(root.left);
        
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }
}
    
