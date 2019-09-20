package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
        //    [100, 4, 200, 1, 3, 2] [] [1] [1,3]
//    [1,2,3,5]
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int ind = 0;
        for (int i = 1; i < nums.length; i++) {
            int j = Arrays.binarySearch(dp, 0, ind+1, nums[i]);
            if (j < 0) j = -(j + 1);

            if (j == ind + 1) {
                dp[j] = nums[i];
                ind++;
            }
            else dp[j] = nums[i];
        }
        return ind + 1;
    }

    // [100,4,200,1,3,2] [] [1] [1,2] [1,2,0,1]
    public int longestConsecutive_nlogn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int length = 1;
        int len = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] - nums[i-1] == 1) len++;
            else if (nums[i] - nums[i-1] == 0) ;
            else {
                length = Math.max(len, length);
                len = 1;
            }
        }
        return Math.max(len, length);
    }

    public int longestConsecutive_n(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> posMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) posMap.put(nums[i], i);

        int res = 1;
        int len = 1;
        for (int i = 0; i < nums.length; i++) {
            if (posMap.get(nums[i]) != -1) {
                posMap.put(nums[i], -1);
                int pre = nums[i] - 1;
                int next = nums[i] + 1;
                while (posMap.get(pre) != null) {
                    posMap.put(pre, -1);
                    pre--;
                    len++;
                }
                while (posMap.get(next) != null) {
                    posMap.put(next, -1);
                    next++;
                    len++;
                }
                res = Math.max(res, len);
                len = 1;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        LongestConsecutiveSequence test = new LongestConsecutiveSequence();

        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        int ans = test.lengthOfLIS(nums);
        System.out.println(ans);

        System.out.println(test.lengthOfLIS(new int[]{1,3}));
    }
}
