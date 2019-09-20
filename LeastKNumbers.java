import java.util.ArrayList;

public class Main {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (input == null || input.length == 0 || input.length < k || k <= 0) return ret;
        
        int n = partition(input, 0, input.length-1);
        int start = 0, end = input.length-1;
        while (n != k - 1) {
            if (n < k - 1) {
                start = n + 1;
                n = partition(input, start, end);
            } else {
                end = n - 1;
                n = partition(input, start, end);
            }
        }
        
        for (int i = 0; i < k; i++) {
            ret.add(input[i]);
        }
        return ret;
    }
    
    public int partition(int[] a, int lo, int hi) {
        if (lo == hi) return lo;
        int v = a[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (Integer.compare(a[++i], v) < 0) {
                if (i == hi) break;
            }
            while (Integer.compare(a[--j], v) > 0) ;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
    }
    
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public ArrayList<Integer> GetLeastNumbers_Solution_2(int [] input, int k) {
        if (input == null || input.length == 0 || input.length < k || k <= 0) return ret;
        PriorityQueue<Integer> maxH = new PriorityQueue<>(k, (i, j) -> j - i);
        for (int i : input) {
            if (maxH.size() < k) {
                maxH.add(i);
            } else {
                if (maxH.peek() > i) {
                    maxH.poll();
                    maxH.add(i);
                }
            }
        }
        
        // for (int i = 0; i < k; i++) {
            // ret.add(maxH.poll());
        // }
        
        ret.addAll(maxH);
        
        return ret;
    }
}