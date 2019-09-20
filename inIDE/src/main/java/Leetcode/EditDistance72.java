package Leetcode;

public class EditDistance72 {
    private int[] record;

    // Convert word1 to word2
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();

        return minEditDistance(word1, word2);
    }

    public int minEditDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;  // from word1 of len i to word2 of len 0, by deleting i times
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;  // from 0 to len i, by inserting
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1] + 1, // insertion
                        Math.min(dp[i][j-1] + 1,  // one insertion from last, so j == j
                                dp[i-1][j] + 1));  // delete current so j == j
            }
        }
        return dp[word1.length()][word2.length()];
    }

    // Complexity: O(n*m)
    public int longestConsecSubseq(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        if (s1.charAt(0) == s2.charAt(0)) {
            dp[0][0] = 1;
//            record[0] = 1;
        }
        // Base cases
        for (int i = 1; i < s1.length(); i++) {
            if (dp[i-1][0] == 1) dp[i][0] = 1;
            else if (s1.charAt(i) == s2.charAt(0)) dp[i][0] = 1;
        }
        for (int i = 1; i < s2.length(); i++) {
            if (dp[0][i-1] == 1) dp[0][i] = 1;
            else if (s2.charAt(i) == s1.charAt(0)) dp[0][i] = 1;
        }
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
//                    record[i] = 1;
                }
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[s1.length()-1][s2.length()-1];
    }

    public static void main(String[] args) {
        EditDistance72 test = new EditDistance72();
        System.out.println(
                test.minDistance("horse", "ros"));
        System.out.println(test
                .minDistance("intention", "execution"));
    }
}
