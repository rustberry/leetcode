package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PermutationsII47 {
    private int n;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>(n);
        Arrays.sort(nums);
        for (int i : nums) {
            l.add(i);
        }
        backtrack(res, l, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> nums, int ind) {
        if (ind == n) {
            res.add(new ArrayList<>(nums));
            return;
        }
        for (int first = ind; first < n; first++) {
//            if (first != ind && nums.get(first).equals(nums.get(ind))) {
//                continue;
//            }
            if (first != ind && nums.get(first).equals(nums.get(first-1))) continue;
            Collections.swap(nums, first, ind);
            backtrack(res, nums, ind + 1);
            Collections.swap(nums, first, ind);
        }
    }

    public static void main(String[] args) {
        PermutationsII47 t = new PermutationsII47();
        System.out.println(
                t.permuteUnique(new int[]{1,2,1,3})
        );
    }
}
