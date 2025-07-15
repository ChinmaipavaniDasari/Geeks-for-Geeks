class Solution {
    public boolean divby13(String s) {
        int remainder = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!Character.isDigit(ch)) {
                return false; 
            }

            int digit = ch - '0';
            remainder = (remainder * 10 + digit) % 13;
        }

        return remainder == 0;
        
    }
}