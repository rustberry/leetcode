class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int start = 0;
        int N = nums.length;
        int l = N + 1;
        for (int end = 0; end < N; end++) {
            sum += nums[end];
            int tempLen = end - start + 1;
            while (sum >= s) {
                if (tempLen < l) {
                    l = tempLen;
                }
                sum -= nums[start];
                start++;

                tempLen = end - start + 1;
            }
        }
        if (l == N + 1) {
            return 0;
        }
        return l;
    }
}