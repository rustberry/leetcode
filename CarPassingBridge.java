

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 有 N 辆车要陆续通过一座最大承重为 W 的桥，其中第 i 辆车的重量为 w[i]，通过桥的时间为 t[i]。要求： 第 i 辆车上桥的时间不早于第 i - 1 辆车上桥的时间；
 *
 * 任意时刻桥上所有车辆的总重量不超过 W。
 *
 * 那么，所有车辆都通过这座桥所需的最短时间是多少？
4 2
1 1 1 1
2 1 2 2
 output: 4
 */
public class Main {
    int n;
    int largest;
    int[] w;
    int[] t;

    public void getInput(Scanner sc) {
        n = sc.nextInt();
        largest = sc.nextInt();
        w = new int[n];
        t = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }

        int minT = Integer.MAX_VALUE, load = 0, cnt = 0;
        LinkedList<Integer> bridge = new LinkedList<>();
        for (int pos = 0; pos < n; ) {
            while (pos < n && load + w[pos] <= largest) {
                load += w[pos];
                minT = Math.min(minT, t[pos]);
                bridge.add(pos);
                pos++;
            }
            if (pos == n) {
                // get max of the remaining
                int max = 0;
                for (Integer integer : bridge) {
                    max = Math.max(max, t[integer]);
                }
                cnt += max;
                System.out.println(cnt);
                return;
            }
            int tmpT = minT;
            for (Integer integer : bridge) {
                t[integer] -= minT;
                if (t[integer] == 0) {
                    bridge.remove(integer);
                    load -= w[integer];
                } else {
                    tmpT = Math.min(tmpT, t[integer]);
                }
            }
            cnt += minT;
            minT = tmpT;
        }
        System.out.println(cnt);
    }


    public static void main(String[] args) {
        Main t = new Main();
        try (Scanner sc = new Scanner(System.in)) {
            t.getInput(sc);
        }
    }
}
