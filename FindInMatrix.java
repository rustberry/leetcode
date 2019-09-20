/**
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
*/
public class FindInMatrix {
    public boolean Find(int target, int [][] array) {
        int colLen = array[0].length;
        int rowLen = array.length;
        int r = 0, c = colLen - 1;
        
        while (r <= rowLen - 1 && c >= 0) {
            if (target == array[r][c]) return true;
            if (target < array[r][c]) {
                c--;
            } else if (target > array[r][c]) {
                r++;
            }
        }
        
        return false;
    }
}