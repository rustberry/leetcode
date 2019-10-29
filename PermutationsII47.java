class Solution {
    boolean[] used;
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        used = new boolean[nums.length];
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>(nums.length);
        for (int i : nums) tmp.add(i);
        perm(res, tmp, 0, nums);
        return res;
    }
    
    private void perm(List<List<Integer>> res, List<Integer> tmp, int ind, int[] nums) {
        if (ind == tmp.size()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            tmp.set(ind, nums[i]);
            used[i] = true;
            perm(res, tmp, ind+1, nums);
            used[i] = false;
        }
        return;
    }
}