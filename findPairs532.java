class Solution {
    public int findPairs(int[] nums, int k) {
        int N = nums.length;
        int cnt = 0;
        if (N <= 1) {
            return cnt;
        } else if (N <= 2){
            if (Math.abs(nums[0] - nums[1]) == k) { return 1; }
        }
        Arrays.sort(nums);
        int pre = nums[0];
        int dif = k + pre;
        // Math.abs(k + pre)
        if (k != 0) {
            if (Arrays.binarySearch(nums, 1, N, dif) >= 0) {
                cnt++;
            }
            for (int i = 1; i < N - 1; i++) {
                if (nums[i] == pre) {
                    continue;
                }
                dif = k + nums[i];
                if (Arrays.binarySearch(nums, i, N, dif) >= 0) {
                    cnt++;
                }
                pre = nums[i];
            }
        } else {
            int preP = Integer.MAX_VALUE;
            pre = nums[0];
            for (int i = 1; i < N; i++) {
                if (preP != Integer.MAX_VALUE && nums[i] == preP) {
                    continue;
                }
                if (nums[i] == pre) {
                    cnt++;
                    // System.out.println(nums[i]);
                }
                pre = nums[i];
                preP = nums[i - 1];
            }
        }
        return cnt;
    }
}