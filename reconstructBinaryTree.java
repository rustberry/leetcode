/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.Arrays;

public class Solution {
    private int[] pre;
    private int[] in;
    
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        this.pre = pre;
        this.in = in;
        return optHelper(0, pre.length-1, 0, in.length-1);
    }
    
    // Optimized version, no new arrays created
    private TreeNode optHelper(int preSindex, int preEindex, int inSindex, int inEindex) {
        int preLen = preEindex - preSindex + 1;
        int inLen = inEindex - inSindex + 1;
        if (preLen == 1 && inLen == 1) return new TreeNode(pre[preSindex]);
        else if (preLen == 0 && inLen == 0) return null;
        
        TreeNode root = new TreeNode(pre[preSindex]);
        
        int inRootPos = 0;
        for (int i = inSindex; i <= inEindex; i++) {
            if (in[i] == root.val) {
                inRootPos = i;
                break;
            }
        }
        
        int LeftSubLen = inRootPos - inSindex;
        
        root.left = optHelper(preSindex + 1, preSindex + LeftSubLen,
                            inSindex, inSindex + LeftSubLen - 1);
        root.right = optHelper(1 + preSindex + LeftSubLen, preEindex,
                            inRootPos + 1, inEindex);
        return root;
    }
}