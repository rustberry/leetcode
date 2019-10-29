package Leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class CowBowling3176POJ {
    public void getInput(Scanner sc) {
        int n = Integer.parseInt(sc.nextLine());
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            String row = sc.nextLine();
            String [] sa = row.split(" ");
            int ind = 0;
            for (String s : sa) {
                mat[i][ind++] = Integer.parseInt(s);
            }
        }
        int len = mat[0].length;
        int[] dp = Arrays.copyOf(mat[n-1], n);
        for (int i = n - 2; i >= 0; i--) {
            len--;
            for (int j = 0; j < len; j++) {
                dp[j] = Math.max(dp[j], dp[j+1]) + mat[i][j];
            }
        }
        System.out.println(dp[0]);
    }

    public static void main(String[] args) {
        CowBowling3176POJ m = new CowBowling3176POJ();
//        try (Scanner sc = new Scanner(System.in)) {
//            m.getInput(sc);
//        }

        Scanner sc = new Scanner(System.in);
        m.getInput(sc);
    }
}
