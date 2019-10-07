package Leetcode;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DicesSum20Lint {
    public static void main(String[] args) {
        DicesSum20Lint t = new DicesSum20Lint();
        int n = 14;
//        System.out.println(t.dicesSum(n));
//        DecimalFormat df = new DecimalFormat("#.##");
//        df.setRoundingMode(RoundingMode.CEILING);

        for (Map.Entry<Integer, Double> entry : t.dicesSum(n)) {
            // df.format(entry.getValue())
            System.out.printf(entry.getKey() + ", %.2f %n", entry.getValue());
        }
    }

    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        long[][] dp = new long[n + 1][n * 6 + 1];
        for (int i = 0; i <= 6; i++) dp[1][i]++;

        for (int i = 2; i <= n; i++) {
            for (int sum = i; sum <= i * 6; sum++) {  // j is sum
                int j = sum - 6 > 0 ? 6 : sum - 1;
                for (; j >= 1; j--) {
                    dp[i][sum] += dp[i-1][sum-j];
                }
            }
        }
        List<Map.Entry<Integer, Double>> res = new ArrayList<>(n * 6);
        double pow = Math.pow(6, n);
        for (int i = n; i <= n * 6; i++) {
            res.add(new AbstractMap.SimpleEntry<>(i, dp[n][i] / pow));
        }
        return res;
    }

    public List<Map.Entry<Integer, Double>> dicesSum1(int n) {
        List<Map.Entry<Integer, Double>> res = new ArrayList<>(n * 6);
        int[] record = new int[n * 6 + 1];
        double pow = Math.pow(6, n);
        emulate(n, 1, 0, record);
        for (int i = 0; i <= n * 6; i++) {
            if (record[i] != 0) {
//                res.add(new AbstractMap.SimpleEntry<Integer, Double>(i, ((double) record[i]/cnt)));
                res.add(new AbstractMap.SimpleEntry<Integer, Double>(i, 1 / pow * record[i]));
            }
        }
        return res;
    }

    public void emulate(int n, int cur, int prev, int[] record) {
        if (cur == n) {
            for (int i = 1; i <= 6; i++) {
                record[prev + i]++;
            }
            return;
        }
        for (int j = 1; j <= 6; j++) {
            emulate(n, cur + 1, prev + j, record);
        }
    }
}
