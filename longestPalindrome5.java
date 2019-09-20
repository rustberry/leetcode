public class longestPalindrome5 {
    // Brute force. n^2 complexity to get all substring, and plus an n to check if is palindrome
    public String longestPali2(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if (checkPali(s, i, j)) maxLen = Math.max(maxLen, );
            }
        }
    }

    // 
    public int longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < len; start++) {
                int end = start + len - 1;
                dp[start][end] = ( || len == 1);
            }
        }
    }
    

    public boolean checkPali(String s, int start, int end) {
        for (; start < end;) {
            if (s.charAt(start++) != s.charAt(end++)) return false;
        }
        return true;
    }
}