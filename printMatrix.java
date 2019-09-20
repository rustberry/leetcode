import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       ArrayList<Integer> res = new ArrayList<>();
       if (matrix == null) return res;
       
       int tr = 0, tc = 0;
       int br = matrix.length - 1, bc = matrix[0].length - 1;
       
       while (tc <= bc && tr <= br) {
           int i = tr, j = tc;
           while (j <= bc) {
               res.add(matrix[i][j++]);
           }
           j--;
           // 2nd print
           i++;
           while (i <= br) {
               res.add(matrix[i++][j]);
           }
           i--;
           // 3rd print
           if (tr < br && tc < bc) {
               j--;
               while (j >= tc) {
                   res.add(matrix[i][j--]);
               }
               j++;
           }
           // 4th print
           if (tr < br - 1 && tc < bc) {
               i--;
               while (i > tr) {
                   res.add(matrix[i--][j]);
               }
           }
           
           
           tc++;
           tr++;
           bc--;
           br--;
       }
       
       return res;
    }
}