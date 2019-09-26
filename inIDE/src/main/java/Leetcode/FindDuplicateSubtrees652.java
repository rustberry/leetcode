package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees652 {
    List<TreeNode> res = new ArrayList<>();
    Map<String, Integer> patternCnt = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        collect(root);
        return res;
    }

    private String collect(TreeNode r) {
        if (r == null) return "#";
        String serial1 = collect(r.left);
        String serial2 = collect(r.right);
        // Add separate symbol here, in case "1", "2" and "12" is mixed.
        String serial = r.val + "," + serial1 + "," + serial2;
        int cnt = patternCnt.getOrDefault(serial, 0);
        if (cnt == 1) res.add(r);
        patternCnt.put(serial, ++cnt);
        return serial;
    }

}
