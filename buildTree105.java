class Solution {
    private int[] pre;
    private int[] in;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // if (preorder == null || inorder == null) return null;
        // return buildHelper(preorder, inorder);
        this.pre = preorder;
        this.in = inorder;
        return optHelper(0, preorder.length-1, 0, inorder.length-1);
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
    
    private TreeNode buildHelper(int[] preorder, int[] inorder) {
        // if (Arrays.equals(preorder, inorder)) { <-- a waste instruction
        if (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        } else if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }
        // }
        TreeNode root = new TreeNode(preorder[0]);
        // System.out.println(root.val);
        
        int inRootPos = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                inRootPos = i;
                break;
            }
        }
        int LeftSubLen = inRootPos;
        
        root.left = buildHelper(Arrays.copyOfRange(preorder, 1, 1+LeftSubLen),
                                        Arrays.copyOfRange(inorder, 0, inRootPos));
                                        
        // System.out.println("Right: " + Arrays.toString(Arrays.copyOfRange(inorder, inRootPos+1, inorder.length)));
        root.right = buildHelper(Arrays.copyOfRange(preorder, 1+LeftSubLen, preorder.length),
                                        Arrays.copyOfRange(inorder, inRootPos+1, inorder.length));
        
        return root;
    }
}