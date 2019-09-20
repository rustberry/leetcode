package Leetcode;

import java.util.Scanner;

// 1. get all indexes of one char 2. DP compute its cost to put them together
// sample input: abcbaa 2
public class ByteDanceCharSwitch {
    private String s;
    private int times;
//    private int[] pos;

    public void getInput(Scanner sc) {
        s = sc.next();
        times = sc.nextInt();
    }

    // abcbaa -> [1, 0, 0, 0, 1, 1] -> [0,4,5]
    // dp(i, j) = dp(i-1, j-1) + (pos[j] - pos[i] - len + 1))
    // dp(i, i+1) = pos[i+1] - pos[i] - 1
    public int maxScr(int[] pos, int start, int end) {
        if (start + 1 == end) {
            int max = 1;
            int cost = pos[end] - pos[start] - 1;  // only two character
            if (cost <= this.times) max = 2;
            return max;
        }

        int max = 1;
        int[][] dp = new int[end+1][end+1];
        for (int i = 1; i <= end; i++) {
            dp[i-1][i] = pos[i] - pos[i - 1] - 1;
            if (dp[i-1][i] <= this.times) max = Math.max(2, max);
        }
        for (int len = 2; len <= end; len++) {  // length of pos is end -start + 1
            for (int i = 0; i + len <= end; i++) {
                dp[i][i+len] = dp[i+1][i+len-1] + pos[i+len] - (pos[i] + len - 1) - 1;
                if (dp[i][i+len] <= this.times) max = Math.max(max, len + 1);
            }
        }

        return max;
    }

    public int consecutiveSame() {
        int[] pos = new int[s.length()];
        int max = 1;
        int ind = 0;
        // get a dp array
        for (int i = 97; i <= 122; i++) {
            ind = 0;  // Remember to reset!
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == i) {
                    pos[ind++] = j;
                }
            }
            if (ind < 2) continue;
//            int cost = minCost(pos, 0, ind - 1);
//            if (cost <= this.times) max = Math.max(max, ind - 1);
            max = Math.max(maxScr(pos, 0, ind - 1), max);
        }

        return max;
    }

    public static void main(String[] args) {
        ByteDanceCharSwitch test = new ByteDanceCharSwitch();
/*        String toTest = "abcbaa 2";
        toTest = "abcbaabb 5";
        toTest = "abcbaabb 0";
        toTest = "oslxlucjsqmfbglzihhxtjwehboynx 20";  // 3
        toTest = "gvlnzdgwdlpiqhimiaeirrgzbtiyky 20";  // 5*/
        try (Scanner sc = new Scanner(System.in)) {
            test.getInput(sc);
            System.out.println(
                    test.consecutiveSame());
        }
    }
}
