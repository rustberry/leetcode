package Leetcode;

public class MultiplyStrings43 {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        if (l1 == 0 || l2 == 0) return "0";
        int[] bits = new int[l1+l2];
        for (int i = l1-1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int n1 = num1.charAt(i)-'0', n2 = num2.charAt(j)-'0';
                int res = n1 * n2;
                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = res + bits[pos2];

                bits[pos1] += sum / 10;  // add carry bit
                bits[pos2] = sum % 10;  // bits[pos2] has already been added in `sum`
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bits.length; i++) {
            if (!(sb.length() == 0 && bits[i] == 0)) sb.append(bits[i]);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }


}
