package Leetcode;

import java.util.Scanner;

// "a" "ab*", "" c*c*"
// "bcbbabab" ".*a*a"
public class RegExpMatching10 {

    public boolean isMatch(String s, String p) {
        return rec(s.toCharArray(), 0, p.toCharArray(), 0);
    }

    private boolean dpMatch(char[] s, char[] p) {
        byte[][] dp = new byte[s.length+1][p.length+1];
        dp[0][0] = 1;
        // todo


        return dp[s.length][p.length] == 1;
    }

    private boolean rec(char[] s, int si, char[] p, int pi) {
        if (si == s.length) {
            if (pi == p.length) return true;
            if (pi + 1 < p.length && p[pi+1] == '*') return rec(s, si, p, pi+2);
            return false;
        }
        if (pi == p.length) return false;

        if (pi + 1 < p.length) {
            if (p[pi + 1] == '*') {
                if (p[pi] == '.' || s[si] == p[pi]) {
                    return rec(s, si + 1, p, pi + 2) || rec(s, si + 1, p, pi)
                            || rec(s, si, p, pi + 2);
                } else {
                    return rec(s, si, p, pi+2);
                }
            } else if (p[pi] == '.' || s[si] == p[pi]){
                return rec(s, si+1, p, pi+1);
            } else {
                return false;
            }
        } else if (p[pi] == '.'|| s[si] == p[pi]) {
            return rec(s, si+1, p, pi+1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        RegExpMatching10 t = new RegExpMatching10();
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                String[] parts = sc.nextLine().split(" ");
                System.out.println(
                        t.isMatch(parts[0], parts[1])
                );
            }
        }
    }
}
