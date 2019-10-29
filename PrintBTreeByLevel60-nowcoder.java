import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
// Print a BTree by level, each for a line.
public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(pRoot);
        int nextLevel = 0, cnt = 1;
        ArrayList<Integer> tmp = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode item = q.poll();
            cnt--;
            tmp.add(item.val);
            
            if (item.left != null) {
                q.add(item.left);
                nextLevel++;
            }
            if (item.right != null) {
                q.add(item.right);
                nextLevel++;
            }
            
            if (cnt == 0) {
                res.add(new ArrayList<>(tmp));
                tmp.clear();
                cnt = nextLevel;
                nextLevel = 0;
            }
        }
        
        return res;
    }
    
}