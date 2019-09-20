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
// Date: 19-05-11
// Link: https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking

public class Solution {
    TreeNode pre = new TreeNode(0);

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        convertHelper(pRootOfTree, pre);
        
        TreeNode ret = pRootOfTree;
        while (ret.left != null) ret = ret.left;
        
        return ret;
    }
    
    private void convertHelper(TreeNode cur, TreeNode pre) {
        if (cur == null) return;
        convertHelper(cur.left, pre);
        
        cur.left = pre.left;
        if (pre.left != null) pre.left.right = cur;
        pre.left = cur;
        
        convertHelper(cur.right, pre);
    }
}

/**
    然而，更好的绕过 Java 方法只能 pass-by-value，没法修改变量值的办法，
    是不在方法中传递变量，使用时直接引用类的字段（field）。
*/
class BetterSolution {
    TreeNode pre;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        convertHelper(pRootOfTree);
        
        TreeNode ret = pRootOfTree;
        while (ret.left != null) ret = ret.left;
        
        return ret;
    }
    
    private void convertHelper(TreeNode cur) {
        if (cur == null) return;
        convertHelper(cur.left);
        
        cur.left = pre;
        if (pre != null) pre.right = cur;
        pre = cur;
        
        convertHelper(cur.right);
    }
}