package Leetcode;

import java.util.Scanner;
/*
1AB2345CD
12345EF
*/
public class LongestCommonSubString {
    private String s1;
    private String s2;

    public void getInput(Scanner sc) {
        s1 = sc.nextLine();
        s2 = sc.nextLine();
    }

    public String longest1d() {
        if (s1 == null || s2 == null) {
            return "-1";
        }
        int[] dp = new int[s1.length()];
        dp[0] = s1.charAt(0) == s1.charAt(0) ? 1 : 0;
        for (int i = 1; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) dp[i] = 1;
        }

        int end = 0, max = dp[0];
        for (int j = 1; j < s2.length(); j++) {
            dp[0] = s1.charAt(0) == s2.charAt(j) ? 1 : 0;
            for (int i = 1; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i] = dp[i-1] + 1;
                    if (dp[i] > max) {
                        max = dp[i];
                        end = i;
                    }
                } else {
                    dp[i] = 0;
                }
            }
        }
        if (max == 0) return "-1";
        return s1.substring(end + 1 - max, end + 1);
    }

    public String longest() {
        if (s1 == null || s2 == null) {
            return "-1";
        }

        int[][] dp = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(0)) dp[i][0] = 1;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == s1.charAt(0)) dp[0][i] = 1;
        }

        int maxI = 0, max = dp[0][0];
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                int len = dp[i-1][j-1];
                if (s1.charAt(i) == s2.charAt(j)) {
                    len += 1;
                    if (len > max) {
                        max = len;
                        maxI = i;
//                        maxJ = j;
                    }
                } else {
                    len = 0;
                }
                dp[i][j] = len;
            }
        }
        String subStr = null;
        if (max == 0) return "-1";
        return s1.substring(maxI+1 - max, maxI+1);
    }

    public static void main(String[] args) {
        LongestCommonSubString test = new LongestCommonSubString();
        try (Scanner sc = new Scanner(System.in)) {
            test.getInput(sc);
            System.out.println(
                    test.longest1d()
            );
        }
    }
}
