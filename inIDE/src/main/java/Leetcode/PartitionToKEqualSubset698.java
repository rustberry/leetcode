package Leetcode;

import java.util.Arrays;

public class PartitionToKEqualSubset698 {
    int cnt = 0;
    boolean finished;
    int k;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        sum /= k;
        this.k = k;
        int set = (1 << nums.length) - 1;  // a set with all elements
        rec(set, 0, nums, 0, sum);
        return cnt == k;
    }

    // Use an integer to minimize memory of the set. Time Limit Exceeded due to exhaustive search.
    private void rec(int set, int ind, int[] a, int curSum, int sum) {
        if (ind == a.length) {
            if (curSum == sum) cnt++;
            if (cnt == k) finished = true;
            else cnt = 0;
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (finished) break;
            if ((set >> i & 1) == 0) continue;
            int tmp = curSum + a[i];
            if (tmp > sum) continue;

            set &= ~(1 << i);  // remove from set
            if (tmp == sum) {
                cnt++;
                tmp = 0;
            }
            rec(set, ind + 1, a, tmp, sum);

            set |= 1 << i;  // undo
        }
    }

    public static void main(String[] args) {
        PartitionToKEqualSubset698 t = new PartitionToKEqualSubset698();
        int[][] test = new int[][]{
                {4, 3, 2, 3, 5, 2, 1}, {10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6},
                {2, 2, 2, 2, 3, 4, 5},
        };
        int[] k = new int[]{
                4, 3, 4
        };

        for (int i = 0; i < k.length; i++) {
            t.cnt = 0;
            t.finished = false;
            System.out.print(Arrays.toString(test[i]) + ", " + k[i] + ":\t");
            System.out.println(t.canPartitionKSubsets(test[i], k[i]) + "\tcnt: " + t.cnt);
        }
    }
}
