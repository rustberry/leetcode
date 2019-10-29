package Leetcode;

// [1,1] []
// [1,1,1,1] [5,4,3,2,1] [2,3,3,3,3,6]
// [1,3,2,4] [4,1,3,3,5] [3,4,2,3]
public class IncreasingTripletSubsequence334 {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int cnt = 0;
        int pos = 1;
        for (; pos < nums.length; pos++) {
            if (nums[pos] <= nums[cnt]) {
                if (cnt - 1 >= 0 && nums[pos] <= nums[cnt - 1]) nums[cnt - 1] = nums[pos];
                else nums[cnt] = nums[pos];
            } else {
                nums[++cnt] = nums[pos];
                if (cnt == 2) return true;
            }
        }
        return false;
    }
}
