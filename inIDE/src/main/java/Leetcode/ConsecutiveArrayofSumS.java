package Leetcode;

import java.util.ArrayList;

public class ConsecutiveArrayofSumS {
    // 1, 2  20
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum <= 2) return res;

        int sml = 1, big = 2;
        int s = 3;
        while (sml * 2 < sum) {
            s = getRangeSum(sml, big);
            if (s < sum) {
                big++;
            } else if (s > sum) {
                sml++;
            } else {
                ArrayList<Integer> ret = new ArrayList<>();
                for (int i = sml; i <= big; i++) ret.add(i);
                res.add(ret);
                sml++;
                big--;
            }
        }

        return res;
    }

    private int getRangeSum(int start, int end) {
        return (start + end) * (end - start + 1) / 2;
    }

    public static void main(String[] args) {
        ConsecutiveArrayofSumS test = new ConsecutiveArrayofSumS();
        System.out.println(
                test.FindContinuousSequence(9)
        );
    }
}
