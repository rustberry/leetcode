package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DifferenceOfOneGeeks {

    /**
     * 7 254545
     * 567 764 465757 5665 878 454 3
     */
    public static void main(String[] args) {
        long[] a;
        int n;
        long k;
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int t = 0; t < T; t++) {
                n = sc.nextInt();
                k = sc.nextLong();
                a = new long[n];
                for (int i = 0; i < n; i++) a[i] = sc.nextLong();
                List<Long> res = new ArrayList<>();
                long tmp;
                for (long i : a) {
                    if (i < k && i > 9) {
                        tmp = i;
                        long prev = i % 10;
                        long cur;
                        boolean illegal = false;
                        while (i / 10 > 0) {
                            i /= 10;
                            cur = i % 10;
                            if (Math.abs(prev - cur) != 1) {
                                illegal = true;
                                break;
                            }
                            prev = cur;
                        }
                        if (!illegal) res.add(tmp);
                    }
                }
                if (res.isEmpty()) System.out.println(-1);
                else {
                    for (long i : res) {
                        System.out.print(i + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
