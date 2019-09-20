public class majorityElement169 {
    public int majorityElement(int[] nums) {
        // if ()
        int p = partition(nums, 0, nums.length - 1);
        int start = 0, end = nums.length - 1;
        int target = nums.length / 2;
        while (p != target) {
            if (p > target) end = p - 1;
            else start = p + 1;
            p = partition(nums, start, end);
        }
        return nums[p];
    }

    public int partition(int[] a, int left, int right) {
        if (left == right) return left;
        int lo = left;
        int hi = right+1;

        int cmp = a[lo];
        while (true) {
            while (a[++lo] < cmp) if (lo >= right) break;
            while (a[--hi] > cmp) ;
            
            if (lo >= hi) break;
            exch(a, lo, hi);
        }
        exch(a, left, hi);
        return hi;
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        majorityElement169 m = new majorityElement169();
        int[][] test = new int[][] {
                            {3,2,3},
                            {4,5,6,7,7,8,7,7,7},
                            {0,0,0},
                            {0},
                            {19,3,8,6,3,5,3,3,3,3}
                        };
        for (int i = 0; i < test.length; i++) System.out.println(""+m.majorityElement(test[i]));
    }
}