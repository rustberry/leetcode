/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Date: 19-04-27
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> pl = new ArrayList<>();
        pathSum1(root, sum, pl, ret);
        return ret;
    }
    
    // f(root, sum) = f(root.left, sum - root.val)
    private void pathSum1(TreeNode root, int sum, List<Integer> pl, List<List<Integer>> ret) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                pl.add(root.val);
                ret.add(pl);
                return;
            } else {
                return;
            }
        }
        if (root.left != null) {
            List<Integer> ppl = new ArrayList<>(pl);
            ppl.add(root.val);
            pathSum1(root.left, sum - root.val, ppl, ret);
        }
        if (root.right != null) {
            pl.add(root.val);
            pathSum1(root.right, sum - root.val, pl, ret);
        }
        
    }
}