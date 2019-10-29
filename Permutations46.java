class Solution {
    private int n;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>(n);
        for (int i : nums) {
            l.add(i);
        }
        backtrack(res, l, 0);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> nums, int ind) {
        if (ind == n) {
            res.add(new ArrayList<Integer>(nums));
            return;
        }

        for (int first = ind; first < n; first++) {
            Collections.swap(nums, first, ind);
            backtrack(res, nums, ind+1);
            Collections.swap(nums, first, ind);
        }
    }
}