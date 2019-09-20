package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// Time elapsed: 34 min
// input: [[5,4],[6,4],[6,7],[2,3]]
public class RussianDollEnvelope {
    private int[] memo;

    // O(n*logn)
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        int[][] dp = new int[envelopes.length][envelopes[0].length];
        Arrays.sort(envelopes, Comparator.comparingInt(arr -> arr[0]));

        dp[0] = envelopes[0];
        int ind = 0;
        for (int i = 1; i < envelopes.length; i++) {
            int pos = bSearchMatrix(dp, 0, ind + 1, envelopes[i]);
            if (pos < 0) pos = -(pos + 1);

            if (pos == ind + 1 && fitsInto(dp[ind], envelopes[i])) {
                dp[pos] = envelopes[i];
                ind++;
            }
            else if (fitsInto(envelopes[i], dp[pos])) {
                dp[pos] = envelopes[i];
                ind++;
            }
        }
        return ind + 1;
    }

    // O(n*2)
    public int maxEnvelopes_n2(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }

        Arrays.sort(envelopes, Comparator.comparingInt(arr -> arr[0]));
        this.memo = new int[envelopes.length];
        memo[0] = 1;
        for (int i = envelopes.length - 1; i >= 0; i--) {
            memoBf(envelopes, i);
        }
        return getMax(memo);
    }

    public int memoBf(int[][] envelopes, int pos) {
        if (memo[pos] != 0) return memo[pos];

        int cnt = 1;
        for (int i = pos - 1; i >= 0; i--) {
            if (fitsInto(envelopes[i], envelopes[pos])) cnt = Math.max(cnt, (memoBf(envelopes, i) + 1));
        }

        memo[pos] = cnt;
        return cnt;
    }

    public boolean fitsInto(int[] arr1, int[] arr2) {
        return arr1[0] < arr2[0] && arr1[1] < arr2[1];
    }

    public int bSearchMatrix(int[][] matrix, int from, int to, int[] key) {
        int l = from, r = to - 1, m = 0;
        while (l <= r) {
            m = (r - l) / 2 + l;
            if (matrix[m][0] > key[0]) {
                r = m - 1;
            } else if (matrix[m][0] < key[0]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -(l + 1);
    }

    public int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        RussianDollEnvelope test = new RussianDollEnvelope();
        int[][] toTest = new int[][] {
                {5,4}, {6,4}, {6,7}, {2,3}
        };
        int ans = test.maxEnvelopes(toTest);
        System.out.println(ans);
    }
}
