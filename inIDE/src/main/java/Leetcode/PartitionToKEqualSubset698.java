package Leetcode;

public class PartitionToKEqualSubset698 {
    int cnt = 0;
    int[] dp;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        sum /= k;
//        dp = new int[sum + 1];
//        if (nums[0] <= sum) dp[nums[0]] = 1;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 0) continue;
            rec(i, 0, nums, k, sum);
        }
        return cnt == k;
    }

    // rec(0, 0, nums, k, sum)
    private boolean rec(int ind, int prev, int[] nums, int k, int sum) {
        if (ind == nums.length - 1) {
            if (prev + nums[ind] == sum) {
                cnt++;
                nums[ind] = 0;
                return true;
            }
            return false;
        }

        if (prev + nums[ind] == sum) {
            nums[ind] = 0;
            cnt++;
            return true;
        } else if (prev + nums[ind] > sum || nums[ind] == 0) {
//            for (int i = ind + 1; i < nums.length; i++) {
//                if (rec(i, prev, nums, k, sum)) {
//                    return true;
//                }
//            }
            return false;
        }

        prev += nums[ind];
        for (int i = ind + 1; i < nums.length; i++) {
            if (rec(i, prev, nums, k, sum)) {
                nums[ind] = 0;
                return true;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets_failed(int[] nums, int k) {
        if (nums.length < k) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) return false;
        sum /= k;
        int[] dp = new int[sum + 1];
        if (nums[0] <= sum) dp[nums[0]] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum; j >= 1; j--) {
                if (j - nums[i] >= 1 && dp[j - nums[i]] != 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
            if (nums[i] <= sum) dp[nums[i]] += 1;
        }
        return dp[sum] >= k;
    }

    public static void main(String[] args) {
        PartitionToKEqualSubset698 t = new PartitionToKEqualSubset698();
        System.out.println(
                t.canPartitionKSubsets(new int[]{10,10,10,7,7,7,7,7,7,6,6,6}, 3)
        );
    }
}
