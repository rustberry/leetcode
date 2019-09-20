package Leetcode;

/**
 * babad  cbbd
 * ""  ac  c cc  abc abcd  zabz zabcz
 */
public class LongestPalindromicSubstring5 {
    String[][] memo;
    String s;

    int[][] record;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;

        this.s = s;
        record = new int[s.length()][s.length()];
        memo = new String[s.length()][s.length()];
//        String ret = memoPalin(0, s.length()-1);
        String ret = memoPalin2(0, s.length()-1);
        if ("".equals(ret)) ret = s.charAt(0) + "";
        return ret;
    }

    private String memoPalin2(int i, int j) {
        if (memo[i][j] != null) return memo[i][j];
        String ret = null;
        if (i == j) ret = s.charAt(i)+"";
        else if (i+1 == j) ret = s.charAt(i) == s.charAt(j) ? s.substring(i, j+1) : "";
        else if (s.charAt(i) == s.charAt(j) && isPalin(i, j)) ret = s.substring(i, j+1);
        else {
            String s1 = memoPalin2(i + 1, j), s2 = memoPalin2(i, j - 1);
            ret = s1.length() > s2.length() ? s1 : s2;
        }
        memo[i][j] = ret;
        return ret;
    }

    private boolean isPalin(int i, int j) {
        if (record[i][j] != 0) return record[i][j] == 1;  // 1 is true
        if (i == j)
            return true;
        if (i + 1 == j) {
            record[i][j] = s.charAt(i) == s.charAt(j) ? 1 : -1;
            return record[i][j] == 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            boolean ret = isPalin(i+1, j-1);
            record[i][j] = ret ? 1 : -1;
            return ret;
        }
        record[i][j] = -1;
        return false;
    }

    private String memoPalin(int i, int j) {
        if (memo[i][j] != null) return memo[i][j];
        if (i + 1 == j) {
            memo[i][j] = s.charAt(i) == s.charAt(j) ? s.substring(i, j+1) : "";
            return memo[i][j];
        }
        if (i == j) {
            memo[i][i] = s.charAt(i) + "";
            return memo[i][i];
        }

        String r1 = memoPalin(i,j-1), r2 = memoPalin(i+1, j);
        memo[i][j] = r1.length() > r2.length() ? r1 : r2;
        if (s.charAt(i) == s.charAt(j)) {
            String ret = memoPalin(i + 1, j - 1);
            if ("".equals(ret)) {
                return memo[i][j];
            }
            if (ret.length() + 2> memo[i][j].length()) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(i));
                sb.append(ret);
                sb.append(s.charAt(j));
                memo[i][j] = sb.toString();
                return memo[i][j];
            }
        }
        return memo[i][j];
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring5 t = new LongestPalindromicSubstring5();
        String[] strings = new String[]{
//                "babad",
//                "cbbd",
//                "a",
//                "ab",
//                "cc",
//                "abc",
//                "zabz",
//                "zabcz",
//                "zaz",
//                "aaabaaaa",
//                "abcdbbfcba",
                "babaddtattarrattatddetartrateedredividerb",
//                "babaddtattarrattatddetartrateedredividerbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        };
        for (String s : strings) {
            System.out.print("Test String: " + s + "   ");
            System.out.println(t.longestPalindrome(s));
        }
    }
}
