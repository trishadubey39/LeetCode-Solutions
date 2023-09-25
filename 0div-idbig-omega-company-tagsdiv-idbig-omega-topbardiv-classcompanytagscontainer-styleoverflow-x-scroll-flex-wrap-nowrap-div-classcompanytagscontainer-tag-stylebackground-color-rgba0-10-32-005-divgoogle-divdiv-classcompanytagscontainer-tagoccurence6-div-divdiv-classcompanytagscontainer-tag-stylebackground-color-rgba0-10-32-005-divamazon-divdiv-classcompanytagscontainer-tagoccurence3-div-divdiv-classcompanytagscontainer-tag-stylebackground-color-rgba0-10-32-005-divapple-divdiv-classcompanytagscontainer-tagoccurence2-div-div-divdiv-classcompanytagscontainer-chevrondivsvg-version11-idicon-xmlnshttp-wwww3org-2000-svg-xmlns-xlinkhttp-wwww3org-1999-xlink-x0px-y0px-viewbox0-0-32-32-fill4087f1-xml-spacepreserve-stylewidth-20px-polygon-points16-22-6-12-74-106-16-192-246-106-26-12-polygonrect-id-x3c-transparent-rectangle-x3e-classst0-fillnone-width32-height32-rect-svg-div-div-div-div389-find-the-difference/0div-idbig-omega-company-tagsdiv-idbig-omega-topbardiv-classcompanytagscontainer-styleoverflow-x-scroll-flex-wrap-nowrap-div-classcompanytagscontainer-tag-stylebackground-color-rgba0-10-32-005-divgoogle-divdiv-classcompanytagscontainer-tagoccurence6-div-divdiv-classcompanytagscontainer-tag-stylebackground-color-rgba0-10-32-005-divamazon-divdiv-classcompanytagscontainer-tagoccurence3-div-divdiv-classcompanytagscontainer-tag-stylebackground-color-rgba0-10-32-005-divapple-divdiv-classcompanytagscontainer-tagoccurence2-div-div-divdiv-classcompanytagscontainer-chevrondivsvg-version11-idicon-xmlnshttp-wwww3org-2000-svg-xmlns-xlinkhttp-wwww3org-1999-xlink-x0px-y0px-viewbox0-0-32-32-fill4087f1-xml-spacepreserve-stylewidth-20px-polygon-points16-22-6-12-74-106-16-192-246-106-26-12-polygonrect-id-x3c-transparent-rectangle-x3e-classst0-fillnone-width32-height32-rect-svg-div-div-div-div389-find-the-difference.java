class Solution {
    public char findTheDifference(String s, String t) {
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();

        Arrays.sort(char1);
        Arrays.sort(char2);

        for(int i=0;i<char2.length; i++){
            if(i>=char1.length){
                return char2[i];
            }
            if(char1[i]!=char2[i])
                return char2[i];
        }
        return 'a';
    }
}