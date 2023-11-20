class Solution {
    public void reverseString(char[] s) {
        int m =0 , n = s.length-1;

        while(m<n){
            char temp = s[m];
            s[m] = s[n];
            s[n]= temp;
            m+=1;
            n-=1;
        } 
    }
}