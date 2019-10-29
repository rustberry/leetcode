package Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

// 16,14,12,10,8,6,4
public class MaxInSlidingWindowNowcoder {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0 || size > num.length) {
            return res;
        }
        if (size == 1) {
            for (int i : num) {
                res.add(i);
            }
            return res;
        }
        Deque<Integer> queue = new ArrayDeque<>(3);
        queue.add(0);
        for (int i = 1; i < size; i++) {
            int cmp = num[i];
            while (!queue.isEmpty() && cmp > num[queue.peekLast()]) queue.removeLast();
            queue.addLast(i);
        }
        res.add(num[queue.peek()]);
        for (int i = size, pre = 1; i < num.length; i++, pre++) {
            int cmp = num[i];
            while (!queue.isEmpty() && (cmp > num[queue.peekLast()] || queue.peekLast() < pre)) {
                queue.removeLast();
            }
            queue.addLast(i);
            while (!queue.isEmpty() && queue.peek() < pre) queue.removeFirst();

            res.add(num[queue.peek()]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxInSlidingWindowNowcoder t = new MaxInSlidingWindowNowcoder();
        System.out.println(
                t.maxInWindows(new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3)
        );
    }
}
