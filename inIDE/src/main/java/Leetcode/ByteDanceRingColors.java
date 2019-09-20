package Leetcode;

import java.util.Scanner;

public class ByteDanceRingColors {
    private int N;
    private int range;  // at least once in range
    private int clrNum;
    private int[][] arr;

    private int[] record;
    private int cnt;

    private int times = 0;

    public void getInput(Scanner sc) {
        N = sc.nextInt();
        range = sc.nextInt();
        clrNum = sc.nextInt() + 1;

//        arr = new int[N][clrNum];
        arr = new int[N+range-1][clrNum];
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num != 0) {
                for (int j = 0; j < num; j++) {
                    int clr = sc.nextInt();
                    arr[i][clr]++;
                }
            }
        }
        // range
        int i = N, j = 0;
        for (; i < arr.length; i++, j++) {
            arr[i] = arr[j];
        }

        record = new int[clrNum];
    }

    // just walk through
    public int invalidCnt() {
        int[] clrCnt = new int[clrNum];
        int l = 0, r = l + range - 1;
        // Initial fill
        for (int i = l; i <= r; i++) {
            for (int j = 0; j < clrNum; j++) {
                int num = arr[i][j];
                clrCnt[j] += num;
            }
        }
        clrInvalid(clrCnt);
        updateClrCnt(clrCnt, false, arr[0]);

        l++; r++;
        for (; r < arr.length; l++, r++) {
            updateClrCnt(clrCnt, true, arr[r]);
            clrInvalid(clrCnt);
            updateClrCnt(clrCnt, false, arr[l]);
        }

//        if (record[0] == 1) cnt--;
        return this.cnt;
    }

    private void clrInvalid(int[] clrCnt) {
        for (int i = 0; i < clrNum; i++) {
            if (clrCnt[i] > 1) {
                if (record[i] != 1) cnt++;
                record[i] = 1;
            }
        }
    }

    private void updateClrCnt(int[] clrCnt, boolean plus, int[] op) {
        if (plus) {
            for (int i = 0; i < clrNum; i++) {
                clrCnt[i] += op[i];
            }
        } else {
            for (int i = 0; i < clrNum; i++) {
                clrCnt[i] -= op[i];
            }
        }
    }

    public static void main(String[] args) {
        ByteDanceRingColors test = new ByteDanceRingColors();
        try (Scanner sc = new Scanner(System.in)) {
            test.getInput(sc);
            System.out.println(test.invalidCnt());
        }
    }
}
