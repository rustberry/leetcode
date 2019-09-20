public class MoreThanHalfNum {
    // [2,2] [1,2,2,3,4,2,6]
    public int MoreThanHalfNum_Solution(int [] array) {
        int ret = 0;
        if (array == null) return ret;
        if (array.length == 1) return array[0];
        
        int j = partition(array, 0, array.length - 1);
        int mid = array.length / 2;
        int start = 0, end = array.length - 1;
        while (j != mid) {
            if (j > mid) {
                end = j - 1;
                j = partition(array, start, end);
            } else {
                start = j + 1;
                j = partition(array, start, end);
            }
        }
        
        ret = array[mid];
        if (!checkMoreThanHalf(array, ret)) ret = 0;
        return ret;
    }
    
    public int partition(int[] array, int lo, int hi) {
        int v = array[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (Integer.compare(array[++i], v) < 0) {
                if (i == hi) break;
            }
            while (Integer.compare(array[--j], v) > 0) System.out.println(j +": "+array[j]);
            
            if (i >= j) break;
            swap(array, i, j);
        }
        swap(array, j, lo);
        return j;
    }
    
    public boolean checkMoreThanHalf(int[] array, int target) {
        int freq = 0;
        for (int i : array) {
            if (i == target) freq++;
        }
        if (freq <= (array.length / 2)) return false;
        else return true;
    }
    
    public void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    
    // public static void main(String[] args) {
        // Solution test = new Solution();
        // int ret = test.MoreThanHalfNum_Solution(new int[] {1,2,3,2,2,2,5,4,2});
        // System.out.println(ret);
    // }
}