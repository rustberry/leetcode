package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

// 2 1 5 3 6 4 8 9 7 -> 1 3 4 8 9
// []
public class LongestIncreasingSubSequence {
    private int N;
    private int[] arr;
    private int[] dp;

    // For Solution B

    public void getInput(Scanner sc) {
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public int[] longestIncSubseq() {
        this.dp = new int[N];
        dp[0] = 1;

        for (int i = N - 1; i >= 0; i--) {
            System.out.println(bfLenAtPos(i) + " for position " + i);
        }

        return fromDPToArr();
    }

    public int bfLenAtPos(int pos) {
        if (dp[pos] != 0) return dp[pos];
        int len = 1;
        for (int i = pos - 1; i > 0; i--) {
                if (arr[pos] > arr[i]) len = Math.max((bfLenAtPos(i) + 1), len);
        }

        dp[pos] = len;
        return len;
    }

    private int[] fromDPToArr() {
        int maxVal = 1, maxPos = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > maxVal) {
                maxVal = dp[i];
                maxPos = i;
            }
        }

        int[] ret = new int[maxVal];
        int retPos = maxVal - 1;

        for (int i = maxPos; i >= 1; i--) {
            if (dp[i] == maxVal) {
                ret[retPos--] = arr[i];
                maxVal--;
            }
        }
        return ret;
    }

    /**
     * Leetcode Longest Increasing Subsequence
     * @param nums
     * @return len of the longest subsq
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] memo = new int[nums.length];
        memo[0] = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            memoBfLengOfLIS(memo, nums, i);
        }
        return getMax(memo);
    }

    // returns the len of LIS at position `pos`
    // failed at [1,3,6,7,9,4,10,5,6]
    public int memoBfLengOfLIS(int[] memo, int[] nums, int pos) {
        if (memo[pos] != 0) return memo[pos];
        int len = 1;
        for (int i = pos - 1; i >= 0; i--) {
            if (nums[i] < nums[pos]) len = Math.max(len, (memoBfLengOfLIS(memo, nums, i) + 1));
        }
        memo[pos] = len;

        return len;
    }

    public int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) if (arr[i] > max) max = arr[i];
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubSequence test = new LongestIncreasingSubSequence();
        String toTest = "9\n2 1 5 3 6 4 8 9 7";
//        toTest = "5\n4 2 3 6 1";
        try (Scanner sc = new Scanner(toTest)) {
            test.getInput(sc);
            System.out.println(Arrays.toString(test.longestIncSubseq()));
        }
        Arrays.binarySearch(new int[3], 0, 8, 3);
    }
}
