package Leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// [] [3] [3,null,9]
public class BTLeverTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int cnt = 1;
        while (!q.isEmpty()) {
            List<Integer> l1 = new ArrayList<>();
            int tmp = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode n = q.poll();
                l1.add(n.val);
                if (n.left != null) {
                    q.add(n.left);
                    tmp++;
                }
                if (n.right != null) {
                    q.add(n.right);
                    tmp++;
                }
            }
            cnt = tmp;
            res.add(l1);
        }
        return res;
    }
}
