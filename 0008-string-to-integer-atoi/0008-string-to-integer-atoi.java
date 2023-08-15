class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        boolean isNegative = false;
        int num = 0;
        int i = 0;

        if (s.length() == 0) {
            return 0;
        }

        if (s.charAt(0) == '-') {
            isNegative = true;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            int digit = Character.getNumericValue(c);
            if (num > (Integer.MAX_VALUE - digit) / 10) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + digit;
        }

        return isNegative ? -num : num;
    
    }
}