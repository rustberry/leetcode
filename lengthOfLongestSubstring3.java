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
        // "abcabcbb"
    }
}