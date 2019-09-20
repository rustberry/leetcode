// class Solution {
public class searchMatrix240 {
/*
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]

  [24, 27, 33, 40, 48]
]
date: 19-6-8
time: 45 min
note the tiny complexity difference of O(M * logN) and O(logN)
*/
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix2(matrix, target);
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (target > matrix[row][col]) row++;
            else col--;
        }

        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        for (int i = 0; i < matrix.length; i++) {
            int col = binarySearchRow(matrix[i], target, 0, matrix[i].length - 1);
            if (matrix[i][col] == target) return true;
        }
        return false;
    }

    public int binarySearchRow(int[] a, int tar, int start, int end) {
        if (start >= end) return start;
        int mid = start + (end - start) / 2;

        while (a[mid] != tar && start < end) {
            if (a[mid] > tar) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
        }
        return mid;
    }

    public int binarySearchMtrx(int[][] a, int tar, int start, int end) {
        if (start >= end) return start;
        int mid = start + (end - start) / 2;

        while (a[mid][0] != tar && start < end) {
            if (a[mid][0] > tar) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            mid = start + (end - start) / 2;
            // binarySearchMtrx(a, tar, start, end);
        }
        return mid;
    }

    public static void main(String[] args) {
        searchMatrix240 s = new searchMatrix240();
        int[][] test = new int[][] {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int[] sample = new int[] {5, 3, 13, 20, 29, 30};
        for (int i : sample) {
            System.out.println(i+": "+s.searchMatrix(test, i));   
        }
    }
}