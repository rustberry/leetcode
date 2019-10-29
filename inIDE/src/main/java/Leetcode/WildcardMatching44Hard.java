package Leetcode;

import java.util.Arrays;

public class WildcardMatching44Hard {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (p.length() == 0) return s.length() == 0;
        char[] sc = s.length() == 0 ? new char[]{'-'} : s.toCharArray();
//        return dpMatch(sc, p.toCharArray());
        return rec(sc, 0, p.toCharArray(), 0);
    }

    private boolean rec(char[] s, int si, char[] p, int pi) {
        if (pi == p.length) return si == s.length;
        if (si == s.length) {
            for (int i = pi; i < p.length; i++) {
                if (p[pi] != '*') return false;
            }
            return true;
        }

        if (s[si] == p[pi] || p[pi] == '?') return rec(s, si + 1, p, pi + 1);
        else if (p[pi] == '*') return rec(s, si, p, pi + 1) || rec(s, si + 1, p, pi + 1)
                || rec(s, si + 1, p, pi);
        else if (s[si] == '-' && p[pi] == '*') return rec(s, si+1, p, pi+1);
        return false;
    }

    private boolean dpMatch(char[] s, char[] p) {
        // 1 is true, 0 is false
        boolean[][] dp = new boolean[s.length][p.length];
        dp[0][0] = s[0] == '-' ? p[0] == '*' : s[0] == p[0] || p[0] == '?' || p[0] == '*';
        for (int j = 1; j < p.length; j++) {
            dp[0][j] = dp[0][j - 1];
        }
        for (int i = 1; i < s.length; i++) {
            dp[i][0] = p[0] == '*';
        }
        for (int i = 1; i < s.length; i++) {
            for (int j = 1; j < p.length; j++) {
                if (s[i] == p[j] || p[j] == '?') dp[i][j] = dp[i - 1][j - 1];
                // Match empty, single, or multiple char
                if (p[j] == '*') dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];
                if (s[i] == '-' && p[j] == '*') dp[i][j] = true;
            }
        }

        return dp[s.length - 1][p.length - 1];
    }

    public static void main(String[] args) {
        WildcardMatching44Hard m = new WildcardMatching44Hard();
        String[][] test = new String[][]{
                {"aa", "a"}, {"aa", "*"}, {"cb", "?a"}, {"adceb", "*a*b"},
                {"", "?"}, {"", "*"}, {"", "****"},
                {"aab", "c*a*b"}, {"mississippi", "m??*ss*?i*pi"},
        };
        for (String[] sa : test) {
            System.out.println(
                    sa[0] + " " + sa[1] + ":\t" + m.isMatch(sa[0], sa[1])
            );
        }
    }
}
