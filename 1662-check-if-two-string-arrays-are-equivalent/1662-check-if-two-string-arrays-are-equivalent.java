class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String first = "";
        String sec = "";

        for (String s : word1) {
            first+=s;
        }
        for (String s : word2) {
            sec+=s;
        }

        return first.equals(sec);
    }
}