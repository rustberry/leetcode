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
    private int ret = 0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        DFSpathSum(root, preSumMap, sum, 0);
        return this.ret;
    }
    
// currentSum - anyPrefixSum = target
// ==> currentSum - target == anyPrefixSum
    private void DFSpathSum(TreeNode root, Map<Integer, Integer> m, int sum, int preSum) {
        if (root == null) return;
        int currentSum = preSum + root.val;
        int oldSum = currentSum - sum;
        this.ret += m.getOrDefault(oldSum, 0);
        
        m.put(currentSum, m.getOrDefault(currentSum, 0)+1);
        
        DFSpathSum(root.left, m, sum, currentSum);
        DFSpathSum(root.right, m, sum, currentSum);
        
        m.compute(currentSum, (k, v) -> v -= 1);
    }
}

    
    
    
    
    
    
    
    
    
    
/** The below won't work, since even if the current sum is bigger than target,
    it may equal to it when met with a negetive number small enough.
    // f(root) = ret + f(root.left) + f(root.right)
    // f(null): 0
    private int pathSumDfs(TreeNode root, int sum, int ps) {
        if (root == null) return 0;
        int r = 0;
        if (root.val + ps == sum) {
            r++;
            ps = 0;
        } else if (root.val == sum) {
            r++;
            ps = 0;
        } else if (root.val + ps > sum) {
            ps = root.val;
        } else {
            ps += root.val;
            // r += pathSumDfs(root.left, sum, ps);
            // r += pathSumDfs(root.right, sum, ps);
        }
        r += pathSumDfs(root.left, sum, ps);
        r += pathSumDfs(root.right, sum, ps);
        return r;
    }
    */