class Solution {
    public String largestOddNumber(String num) {
        String sum = "";
        if (num.charAt(num.length()-1) % 2 != 0) {
            return num;
        } else {
            for (int i = num.length()-1;i>=0;i--) {
                if (Integer.parseInt(String.valueOf(num.charAt(i))) % 2 != 0) {
                    sum = num.substring(0, i+1);
                    return sum;
                }
            }
            return sum;
        }
    }
}