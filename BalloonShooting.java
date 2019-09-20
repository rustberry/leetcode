public class BalloonShooting {
    /**
     * 1. if left and right remains ballon not hit: L * X * R
     * 2. if on the left no balloon left but right remains: X * R; otherwise: X * L
     * 3. if both left and right nothing left: X
     * 
     * assume that all scores are positive
     */

    public static void main(String[] args) {
        BalloonShooting b = new BalloonShooting();
        int[] ballons = new int[] {3,2,5};
        System.out.println(b.shoot(ballons));
    }

    public int memoDP(int[] ballons) {
        if (ballons == null || ballons.length == 0) return 0;
        int[][] dp = new int[ballons.length+1][ballons.length];
        for (int hits = 1; hits < ballons.length+1; hits++) {
            for (int bln = 0; bln < ballons.length; bln++) {
                dp[hits][bln] = 1;
                getScore(ballons, dp[hits], bln);
            }
        }
    }

    public int shoot(int[] ballons) {
        if (ballons == null || ballons.length == 0) return 0;
        int[] record = new int[ballons.length];
        // return backtrack(ballons, record);
        int ret = 0;
        for (int i = 0; i < ballons.length; i++) {
            record[i] = 1;
            ret = Math.max(backtrack(ballons, record, i), ret);
            record[i] = 0;
        }
        return ret;
    }

    public int backtrack(int[] ballons, int[] record, int index) {
        // if (index == ballons.length) return 0;

        int ret = getScore(ballons, record, index);
        int tmp = 0;
        for (int i = 0; i < ballons.length; i++) {
            if (record[i] != 0) continue;
            record[i] = 1;
            tmp = Math.max(tmp, backtrack(ballons, record, i));
            record[i] = 0;
        }
        return ret + tmp;
    }

    private int getScore(int[] ballons, int[] record, int index) {
        int score = ballons[index];
        int left = 1, right = 1;
        for (int i = index-1; i >= 0; i--) {
            if (record[i] == 0) left = ballons[i];
        }
        for (int i = index+1; i < ballons.length; i++) {
            if (record[i] == 0) right = ballons[i];
        }
        return score * left * right;
    }
}