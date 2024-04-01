class Solution {
    public int lengthOfLastWord(String s) {
        int j = s.trim().length() - 1;
        int result = 0;
        while (j >= 0) {
            if (s.trim().charAt(j) == ' ')
                return result;
            else
                result++;

            j--;
        }
        return result;
    }
}