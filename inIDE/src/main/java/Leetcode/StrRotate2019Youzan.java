package Leetcode;

import java.util.Scanner;

public class StrRotate2019Youzan {

    public boolean getInput(Scanner sc) {
        String[] sa = sc.nextLine().split(";");
        String a = sa[0], b = sa[1];
        if (a.length() != b.length()) return false;

        int ai = 0, bi = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(0)) {
                ai = i;
                bi = 0;
                while (ai < a.length() && bi < b.length()) {
                    if (a.charAt(ai++) != b.charAt(bi++)) break;
                }
                if (ai != a.length()) continue;
                ai = 0;
                while (ai < a.length() && bi < b.length()) {
                    if (a.charAt(ai++) != b.charAt(bi++)) break;
                }
                if (bi == b.length() && ai == i) return true;
            }
        }
        return false;
    }

    public boolean part2Array(Scanner sc) {
        String tmp = sc.nextLine();
        String[] sa = tmp.substring(1, tmp.length()-1).split(",");
        int[] a = new int[sa.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(sa[i]);
        }
        byte[] bitmap = new byte[a.length];
        int i = 0;
        while (i < a.length && i >= 0) {
            if (bitmap[i] == 1) return false;
            bitmap[i] = 1;
            i += a[i];
        }
        return true;
    }

    public static void main(String[] args) {
        StrRotate2019Youzan m = new StrRotate2019Youzan();
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                System.out.println(
    //                    m.getInput(sc)
                        m.part2Array(sc)
                );
            }
        }
    }
}
