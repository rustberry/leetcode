class Solution {
    public int findComplement(int num) {
        if (num == 0 || num == 1) return num ^ 1;
        int tmp = num;
        int cnt = 1;
        while ((tmp >>= 1) != 0) cnt++;
        
        int mask = 0;
        // the cleaniest way to compute a mask of a number
        mask = (Integer.highestOneBit(num) << 1) - 1;
        // while (cnt-- > 0) mask = mask * 2 + 1;
        return num ^ mask;
    }
}