public class Solution {
    public int NumberOf1(int n) {
        
        int res = 0;
        int num = n;
        // if (n < 0) num &= 0x7FFFFFF;
        // while (num != 0) {
            // if ((num & 1) == 1) res++;
            // num >>= 1;
        // }
        // if (n < 0) res++;
        while (num != 0) {
            num = num & (num - 1);
            res++;
        }
        return res;
    }
}