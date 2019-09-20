class Solution {
    // [], [2]
    public int longestConsecutive(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i : nums) {
            map.put(i, 1);
        }
        int max = 0;
        int get = 0;
        for (int i : nums) {
            if ((get = map.getOrDefault(i, -1)) != 0 && get != -1) {
                int len = 1 + getConseqNum(map, i, -1) + getConseqNum(map, i, 1);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    
    // toRight = 1 or -1, for 1: search the right hand, and vice versa
    public int getConseqNum(Map<Integer, Integer> map, int tar, int toRight) {
        int len = 0;
        int res = tar + toRight;
        while (map.getOrDefault(res, -1) != -1) {
            len++;
            map.put(res, 0);
            res += toRight;
        }
        return len;
    }
}