public class CattleBreed {
    /**
     * f(yr) = f(yr-1) + f(yr-3);
     * init: f(1) = 1; f(5) = 6; f(6) = 9;
     * 1,1  2,2  3,3  4,4  5,6  6,9  7,13
     */
    public int cattleInNYear(int yr) {
       int pPre = 1;
       int pre = 2;
       int res = 3;
       for (int i = 4; i <= yr; i++) {
           int tmp = res;
           res += pPre;

           pPre = pre;
           pre = tmp;
       }
       return res;
    }

    public int bForceCattleNum(int yr) {
        if (yr <= 4) return yr;
        // int ret = 0;
        return bForceCattleNum(yr - 1) + bForceCattleNum(yr - 3);
    }

    public static void main(String[] args) {
        CattleBreed c = new CattleBreed();
        int yr = 58;

        long start=System.currentTimeMillis();
        System.out.println(c.cattleInNYear(yr));
        long end=System.currentTimeMillis();
        System.out.println(String.format("Time used: %.3fs", (end-start)/1000.0));

        start=System.currentTimeMillis();
        System.out.println(c.bForceCattleNum(yr));
        end=System.currentTimeMillis();
        System.out.println(String.format("Time used: %.3fs", (end-start)/1000.0));
    }
}