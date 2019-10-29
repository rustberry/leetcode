public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str == null || n < 0) return null;
        
        int len = str.length();
        if (n == len) return str;
        if (n > len) {
            n %= len;
            if (n == 0) return str;
        }
        StringBuilder sb = new StringBuilder(str.substring(n, len));
        sb.append(str.substring(0, n));
        return sb.toString();
    }
}