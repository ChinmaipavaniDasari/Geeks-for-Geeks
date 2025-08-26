class Solution {
    public boolean isSubSeq(String s1, String s2) {
         if (s1.length() > s2.length()) {
            return false;
        }
        
        int l = 0;
        for (int i = 0; i < s2.length() && l < s1.length(); i++) {
            if (s2.charAt(i) == s1.charAt(l)) {
                l++;
            }
        }
        
        return l == s1.length();
    }
};