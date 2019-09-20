public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) return 0;
        
        int kBeg = k - 1, kEnd = k + 1;
        int beg = binarySearch(array, kBeg);
        if (array[beg] == k) {
           if (beg > 0) beg--;
        }

        int end = binarySearch(array, kEnd);
        if (array[end] == k) {
           if (end < array.length - 1) end++;
        }

        int ret = end - beg - 1;
        return ret;
    }
    
    // 1,3,4,6  1,2,4,4,4(,6)
    private int binarySearch(int[] a, int k) {
        int lo = 0, hi = a.length - 1;
        if (lo == hi || a.length == 0) return 0;
        int mid = lo + (hi - lo) / 2;
        while (lo != hi) {
            if (a[mid] == k) {
                return mid;
            } else if (a[mid] < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
            mid = lo + (hi - lo) / 2;
        }
        
        return mid;
            
    }
}