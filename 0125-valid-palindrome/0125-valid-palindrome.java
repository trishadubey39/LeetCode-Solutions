class Solution {
    public boolean isPalindrome(String s) {
        String t = s.replaceAll("[^a-zA-Z0-9_-]","").replaceAll("[_+$=-]", "").toLowerCase();
        int m =0 , n = t.length()-1;

        while(m<n){
            if(t.charAt(m)!=(t.charAt(n))){
                return false;
            }
            m++;
            n--;
        }
        return true;
    }
}