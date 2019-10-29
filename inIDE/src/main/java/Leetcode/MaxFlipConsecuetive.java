package Leetcode;

import java.util.Scanner;

public class MaxFlipConsecuetive {
    int n, m;
    String s;

    public void getInput(Scanner sc) {
        n = sc.nextInt();
        m = sc.nextInt();
        s = sc.nextLine();
        if (s == null || s.length() == 0) s = sc.nextLine();
        char[] a = s.toCharArray();
        char cmp = 'a';
        int res = 0;
        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < a.length - m; i++) {
                int cnt = 0, times = m;
                while (times > 0 && i < a.length - m) {
                    if (a[i] == cmp) {
                        cnt++;
                        i++;
                    } else if (times > 0) {
                        times--;
                        cnt++;
                        i++;
                    }
                }
                if (i == a.length - m) {
                    res = Math.max(res, cnt);
                    continue;
                }
                for (int j = i; j < a.length; j++) {
                    if (a[j] != cmp) break;
                    cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        MaxFlipConsecuetive t = new MaxFlipConsecuetive();
        try (Scanner sc = new Scanner(System.in)) {
            t.getInput(sc);
        }
    }
}
