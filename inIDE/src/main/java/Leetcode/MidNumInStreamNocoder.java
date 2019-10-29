package Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MidNumInStreamNocoder {
    PriorityQueue<Integer>
            max = new PriorityQueue<>(Comparator.comparingInt(v -> -v)),
            min = new PriorityQueue<>();
    boolean toMin = false;
    int cnt = 0;

    public void Insert(Integer num) {
        if (toMin) {
            if (!max.isEmpty() && num < max.peek()) {
                max.add(num);
                min.add(max.poll());
            } else {
                min.add(num);
            }
            toMin = false;
        } else {
            if (!min.isEmpty() && num > min.peek()) {
                min.add(num);
                max.add(min.poll());
            } else {
                max.add(num);
            }
            toMin = true;
        }
        cnt++;
    }

    public Double GetMedian() {
        if ((cnt & 0x1) == 0) {  // even
            double res = (max.peek() + min.peek()) / 2.0;
            return res;
        }
        return Double.valueOf(max.size() > min.size() ? max.peek() : min.peek());
    }

    public static void main(String[] args) {
        MidNumInStreamNocoder t = new MidNumInStreamNocoder();
        int[] test = new int[] {5,2,3,4,1,6,7,0,8};
        for (int i : test) {
            t.Insert(i);
            System.out.println(t.GetMedian());
        }
    }
}
