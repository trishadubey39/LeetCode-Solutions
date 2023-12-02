class Solution {

    private int [] count(String s){
        int[] arr = new int [26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        return arr;
    }

    private boolean check(int[] chars, int[] word){
        for(int i=0; i<26; i++){
            if(chars[i] < word[i]) return false;
        }
        return true;
    }

    public int countCharacters(String[] words, String chars) {
        int []cnt_char = count(chars);
        int res=0;
        for(String word : words){
            int []cnt_word = count(word);

            if(check(cnt_char, cnt_word)){
                res += word.length();
            }
        }
        return res;
    }
}