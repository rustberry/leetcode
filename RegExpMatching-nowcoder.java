public class Solution {
    // "bcbbabab", ".*a*a"  "", "."
    public boolean match(char[] str, char[] pattern) {
        if ((str == null || str.length == 0) && (pattern == null || pattern.length == 0))
            return true;
        if (pattern == null || pattern.length == 0) return false;
         
        return coreMatch(str, 0, pattern, 0);
    }
     
    private boolean coreMatch(char[] str, int i, char[] pattern, int p) {
        if (p >= pattern.length) {
            return i >= str.length;
        } else if (i >= str.length && pattern[p] == '.') {
            if (p + 1 < pattern.length) {
                if (pattern[p+1] == '*') return coreMatch(str, i, pattern, p+2);
                else return coreMatch(str, i, pattern, p+1);
            } else return true;
        }
         
        if (p + 1 < pattern.length) {
            if (pattern[p+1] != '*') {
                if (pattern[p] != '.' && (i >= str.length || pattern[p] != str[i])) return false;
                return coreMatch(str, i+1, pattern, p+1);
            } else {
                if (pattern[p] != '.' && (i >= str.length || pattern[p] != str[i])) return coreMatch(str, i, pattern, p+2);
                return coreMatch(str, i+1, pattern, p+2) 
                    || coreMatch(str, i, pattern, p+2) || coreMatch(str, i+1, pattern, p);
                    // || coreMatch(str, i+1, pattern, p+2)
            }
        } else {
            if (i != str.length-1) return false;
            if (pattern[p] == '.') return true;
            else return i < str.length && pattern[p] == str[i];
        }
    }
}