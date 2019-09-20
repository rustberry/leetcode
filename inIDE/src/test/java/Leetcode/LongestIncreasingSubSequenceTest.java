package Leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LongestIncreasingSubSequenceTest {

    @Test
    public void longestIncSubseq() {
        int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
        int[] memo = new int[nums.length];
        memo[0] = 1;
        LongestIncreasingSubSequence test = new LongestIncreasingSubSequence();

        assertEquals(6,test.lengthOfLIS(nums));
    }

    @Test
    public void nlogn_LIS() {
        int[] nums = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        getDP2(nums);
        assertEquals(5, lenOfLIS(nums));
    }

    private int[] getDP2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;

        int rightBound = 0;
        int l = 0, r = 0, m = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = rightBound;

            l = Arrays.binarySearch(ends, l, r, arr[i]);
            if (l < 0) l = -(l + 1);

            while (l <= r) {
                m = (l + r) / 2;
                if (ends[m] < arr[i]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            rightBound = Math.max(rightBound, l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    private int lenOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}