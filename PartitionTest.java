
class PartitionTest {
    // [2,0,2,1,1,0]  [1,0,2,2,1,0] --> [1 0,0,1,2,2]
    // [1,0,0,1,2,2]
    public void sortColors(int[] nums) {
        if (nums == null) return;
        
        int onePos = 0;
        for (int i : nums) {
            if (i == 1) break;
            onePos++;
        }
        swap(nums, onePos, 0);
        
        partition(nums, 0, nums.length - 1);
        return;
    }
    
    public void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }
    
    public int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = nums[lo];
        // int v = 1;
        while (true) {
            while (Integer.compare(nums[++i], v) < 0) {
                if (i == hi) break;
            }
            while (Integer.compare(nums[--j], v) > 0) ;
            
            if (i >= j) break;
            swap(nums, i, j);
        }
        if (nums[j - 1] == 0) swap(nums, j - 1, lo);
        else swap(nums, j, lo);
        
        return j;
    }
    
    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}