class Solution {
    public int lengthOfLongestSubstring(String s) {
        return lengthOfLongestSubstring1(s);
    }
    
    
    private int lengthOfLongestSubstring1(String s) {
        if (s == null) return 0;
        
        int preIndex = 0;
        int len = 0;
        String cur;
        Set<String> preS = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            cur = s.substring(i, i+1);
            if (preS.contains(cur)) {
                if (preS.size() > len) {
                    len = preS.size();
                }
                // restore
                while (!preS.isEmpty() && preS.contains(cur)) {
                    String pre = s.substring(preIndex, preIndex+1);
                    preS.remove(pre);
                    preIndex++;
                }
                preS.add(cur);
            } else {
                preS.add(cur);
            }
        }
        
        // if (len == 0) {
            // len = s.length();
        // }
        if (len < preS.size()) len = preS.size();
        return len;
        // "a", "", "aa", "aaaa", "zabcab"
        // "aaab"
        // "abcabcbb", "bacabc"
    }
    
    public int theStandardSlidingWindowSolution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) return 1;
        
        int i = 0;
        int j = 1;
        int ret = 1;
        Set<Character> preSet = new HashSet<>();
        preSet.add(s.charAt(0));
        
        for (;j < s.length();) {
            if (!preSet.contains(s.charAt(j))) {
                preSet.add(s.charAt(j));
                ret = Math.max(ret, j - i + 1);  // note to plus one
                 j++;
            } else {
                preSet.remove(s.charAt(i));
                i++;
            }
        }
        
        return ret;
    }
}