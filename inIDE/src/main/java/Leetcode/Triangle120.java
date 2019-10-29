package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// [[2],[3,4],[6,5,7],[4,1,8,3]]
public class Triangle120 {
    // this one is a little bit faster, since it omits the calculation of the largest bottom one.
    public int minimumTotal(List<List<Integer>> triangle) {
        int numRows = triangle.size();
        List<Integer> curr;
        List<Integer> below = triangle.get(numRows - 1);

        for (int i = numRows - 2; i >= 0; i--) {
            curr = triangle.get(i);
            below = buildMin(curr, below);
        }

        return below.get(0);
    }

    private List<Integer> buildMin(List<Integer> curr, List<Integer> below) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < curr.size(); i++) {
            int min = Math.min(below.get(i), below.get(i + 1));
            result.add(curr.get(i) + min);
        }
        return result;
    }


    public int minimumTotal_slow_UpToDown(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        dp[0] = triangle.get(0).get(0);
        for (List<Integer> list : triangle) System.out.println(list);

        for (int i = 1; i < triangle.size(); i++) {
            int rowSize = triangle.get(i).size();
            dp[rowSize - 1] = dp[rowSize - 2] + triangle.get(i).get(rowSize - 1);
            for (int j = rowSize - 2; j > 0; j--) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        for (int i : dp) System.out.print(i + ", ");

        int min = Integer.MAX_VALUE;
        for (int i : dp)
            if (min > i) {
                min = i;
            }
        return min;
    }

    private List<List<Integer>> stringToInt2dList(String s) {
        s = s.replaceAll("\\[", "").replaceAll("\\],", " ");
        s = s.substring(0, s.length() - 2);
        String[] parts = s.split(" ");
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < parts.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            String[] sa = parts[i].split(",");
            for (String s1 : sa) {
                tmp.add(Integer.parseInt(s1));
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        Triangle120 t = new Triangle120();
        try (Scanner sc = new Scanner(System.in)) {
//            List<List<Integer>> test = t.stringToInt2dList(sc.nextLine());
            List<List<Integer>> test = t.stringToInt2dList("[[-7],[-2,1],[-5,-5,9],[-4,-5,4,4],[-6,-6,2,-1,-5],[3,7,8,-3,7,-9],[-9,-1,-9,6,9,0,7],[-7,0,-6,-8,7,1,-4,9],[-3,2,-6,-9,-7,-6,-9,4,0],[-8,-6,-3,-9,-2,-6,7,-5,0,7],[-9,-1,-2,4,-2,4,4,-1,2,-5,5],[1,1,-6,1,-2,-4,4,-2,6,-6,0,6],[-3,-3,-6,-2,-6,-2,7,-9,-5,-7,-5,5,1]]");
            System.out.println("\n" + t.minimumTotal(test));
        }
    }
}
