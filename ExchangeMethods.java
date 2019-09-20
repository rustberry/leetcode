import java.util.Arrays;

public class ExchangeMethods {

    public static void main(String[] args) {
        ExchangeMethods e = new ExchangeMethods();
        int[] test = new int[] {5,10,25,1};
        int aim = 15;
        int[][] map = new int[test.length][aim+1];
        for (int i = 0; i < test.length; i++) Arrays.parallelSetAll(map[i], (ele)-> -1);
        System.out.println("bfRecurWithMemo "+e.bfRecurWithMemo(test, 0, aim, map)); // return 6
        for (int i = 0; i < test.length; i++) System.out.println(Arrays.toString(map[i]));

        System.out.println("allMethods: "+e.allMethods(test, aim));
        System.out.println("allMethodsSpaceOptimized: "+e.allMethodsSpaceOptimized(test, aim));
    }

    public int allMethods(int[] a, int aim) {
        if (a == null || a.length == 0 || aim == 0) return 0;

        int[][] dp = new int[a.length][aim+1];
        for (int i = 1; i * a[0] <= aim; i++) {
            dp[0][i*a[0]] = 1;
        }
        for (int i = 0; i < a.length; i++) {
            dp[i][0] = 1;
        }
        // System.out.println(Arrays.deepToString(dp));

        for (int i = 1; i < a.length; i++) {
            for (int rest = 1; rest <= aim; rest++) {
                if (rest - a[i] >= 0) {
                    dp[i][rest] = dp[i][rest-a[i]] + dp[i-1][rest];
                } else {
                    dp[i][rest] = dp[i-1][rest];
                }
            }
        }
        // for (int i = 0; i < a.length; i++) System.out.println(Arrays.toString(dp[i]));
        return dp[a.length-1][aim];
    }

    // space optimized version, reduced to O(aim); times accessing the table also reduced.
    public int allMethodsSpaceOptimized(int[] a, int aim) {
        if (a == null || a.length == 0 || aim == 0) return 0;

        int[] dp = new int[aim+1];
        for (int i = 0; i * a[0] <= aim; i++) {
            dp[i*a[0]] = 1;
        }
        for (int len = 1; len < a.length; len++) {
            for (int rest = 1; rest <= aim; rest++) {
                if (rest - a[len] >= 0) {
                    dp[rest] += dp[rest-a[len]];
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[aim];
    }

    public int bfRecur(int[] a, int index, int aim) {
        int ret = 0;
        if (index == a.length - 1) return aim % a[index] == 0 ? 1 : 0;
        if (aim == 0) return 1;
        for (int i = 0; aim - i * a[index] >= 0; i++) {
            ret += bfRecur(a, index + 1, aim - i * a[index]);
        }

        return ret;
    }

    /**
     * slightly optimized from Brutal Force
     * the size: map is new int[a.length][aim+1]
     */
    public int bfRecurWithMemo(int[] a, int index, int aim, int[][] map) {
        if (aim == 0) return 1;
        if (map[index][aim] != -1) return map[index][aim];

        if (index == a.length - 1) {
            map[a.length-1][aim] = aim % a[index] == 0 ? 1 : 0;
            return map[a.length-1][aim];
        }

        int ret = 0;
        for (int i = 0; aim - i * a[index] >= 0; i++) {
            int m = map[index][aim-i*a[index]];
            if (m != -1) ret += m;
            else {
                m = bfRecurWithMemo(a, index + 1, aim - i * a[index], map);
                map[index+1][aim-i*a[index]] = m;
                ret += m;
                // map[index][aim-i*a[index]] = ret;
            }
        }

        return ret;
    }

}