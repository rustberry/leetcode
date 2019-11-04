package Leetcode;

import java.util.Arrays;

public class RangeSumQueryImmutable303Ez {
    public static void main(String[] args) {
        int[] tot = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray m = new NumArray(tot);
        System.out.println(Arrays.toString(m.a)+":\tgenerated array");
        int[][] test = new int[][] {
                {0,2},{2,5},
                {0,5},{0,1},{0,3},
                {1,2},{3,4},
        };
        for (int[] a : test) {
//            System.out.println(Arrays.toString(a) + ": "+m.sumRange(a[0], a[1]));
        }
        System.out.println(Arrays.toString(test[0]) + ": "+m.sumRange(test[0][0], test[0][1]));
        m.update(0,1);
        System.out.println(Arrays.toString(test[0]) + ": "+m.sumRange(test[0][0], test[0][1]));

    }
}


class NumArray {
    int[] a;
    int _n;

    public NumArray(int[] nums) {
        int n = nums.length;
        int n_ = 1;
        while (n_ < n) n_ *= 2;
        a = new int[2 * n_];
        this._n = n_;
        init(1, 0, n_ - 1, nums);
    }

    private int init(int k, int l, int r, int[] nums) {
        if (l == r) {
            if (l >= nums.length) return 0;
            a[k] = nums[l];
            return a[k];
        }
        int mid = l + (r - l) / 2;
        a[k] = init(2*k, l, mid, nums) + init(2*k + 1, mid + 1, r, nums);
        return a[k];
    }

    public int sumRange(int i, int j) {
        return sum0(i, j, 1, 0, _n - 1);
    }

    private int sum0(int x, int y, int k, int l, int r) {
        if (x == l && y == r) return a[k];
        if (x > r || y < l) return -1;
        int mid = l + (r-l) / 2;
        if (x > mid) {
            return sum0(x, y, k*2+1, mid+1, r);
        }
        if (y <= mid) {
            return sum0(x, y, 2*k, l, mid);
        }
        // x <= mid && y > mid
        return sum0(x, mid, 2*k, l, mid)
                + sum0(mid+1, y, 2*k+1, mid+1, r);
    }

    public void update(int i, int val) {
        update0(i, val, 1, 0, this._n-1);
    }

    private int update0(int i, int val, int k, int l, int r) {
        if (l == r && i == l) {
            int diff = a[k] - val;
            a[k] = val;
            return diff;
        }
        int mid = l + (r-l) / 2;
        int diff;
        if (i <= mid) diff = update0(i, val, k * 2, l, mid);
        else diff = update0(i, val, k*2+1, mid+1, r);
        a[k] -= diff;
        return diff;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

