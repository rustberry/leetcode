public class longestSubstring395 {
// class Solution {
    public int longestSubstring(String s, int k) {
        if (k == 1) return s.length();
        if (s.length() < k) return 0;

        // count every occurence, store them in map
        int[] map = new int[26];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 97] += 1; // (int) 'a' = 97
        }

        int max = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 0) continue;  // map[i] == 0 means that it wasn't in the String

            if (map[i] < k) {
                String[] buf = s.split("" + (char)(i+97));
                for (String str : buf) {
                    max = Math.max(max, longestSubstring(str, k));
                }
                return max;
            }
        }
        return s.length();
    }

    public static void main(String[] args) {
        longestSubstring395 l = new longestSubstring395();
        String s = "abcdedghijklmnopqrstuvwxyz";
        String s2 = "abdbbeabcddc";
        int k = 2;
        System.out.println(
            l.longestSubstring(s2, k));
    }
}