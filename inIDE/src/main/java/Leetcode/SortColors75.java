package Leetcode;

// Input: [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
public class SortColors75 {
    private final int sortsNum = 3;

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        bucketSort(nums, this.sortsNum);
    }

    public void bucketSort(int[] nums, int sortsNum) {
        int[] bucket = new int[sortsNum];

        for (int i : nums) {
            bucket[i]++;
        }

        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j] > 0) {
                nums[i++] = j;
                bucket[j]--;
            }
        }
    }
}
