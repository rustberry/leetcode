package Leetcode;

import java.util.Scanner;

// input
// 5
//1 2 3 3 5
//3
//1 2 1
//2 4 5
//3 5 3
public class ByteDanceQuery {
    private int N;
    private int[] arr;
    private int Q;

//    private int times = 0;

    public void getInput(Scanner sc) {
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Q = sc.nextInt();
    }

    public int queryRet(int l, int r, int tar) {
        int cnt = 0;
        for (int i = l-1; i <= r-1; i++) {
            if (arr[i] == tar) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        ByteDanceQuery test = new ByteDanceQuery();
        int l = 0, r = 0, tar = 0;
        try (Scanner sc = new Scanner(System.in)) {
            test.getInput(sc);
            for (int i = 0; i < test.Q; i++) {
                l = sc.nextInt();
                r = sc.nextInt();
                tar = sc.nextInt();
                System.out.println(test.queryRet(l, r, tar));
            }
        }
    }
}
