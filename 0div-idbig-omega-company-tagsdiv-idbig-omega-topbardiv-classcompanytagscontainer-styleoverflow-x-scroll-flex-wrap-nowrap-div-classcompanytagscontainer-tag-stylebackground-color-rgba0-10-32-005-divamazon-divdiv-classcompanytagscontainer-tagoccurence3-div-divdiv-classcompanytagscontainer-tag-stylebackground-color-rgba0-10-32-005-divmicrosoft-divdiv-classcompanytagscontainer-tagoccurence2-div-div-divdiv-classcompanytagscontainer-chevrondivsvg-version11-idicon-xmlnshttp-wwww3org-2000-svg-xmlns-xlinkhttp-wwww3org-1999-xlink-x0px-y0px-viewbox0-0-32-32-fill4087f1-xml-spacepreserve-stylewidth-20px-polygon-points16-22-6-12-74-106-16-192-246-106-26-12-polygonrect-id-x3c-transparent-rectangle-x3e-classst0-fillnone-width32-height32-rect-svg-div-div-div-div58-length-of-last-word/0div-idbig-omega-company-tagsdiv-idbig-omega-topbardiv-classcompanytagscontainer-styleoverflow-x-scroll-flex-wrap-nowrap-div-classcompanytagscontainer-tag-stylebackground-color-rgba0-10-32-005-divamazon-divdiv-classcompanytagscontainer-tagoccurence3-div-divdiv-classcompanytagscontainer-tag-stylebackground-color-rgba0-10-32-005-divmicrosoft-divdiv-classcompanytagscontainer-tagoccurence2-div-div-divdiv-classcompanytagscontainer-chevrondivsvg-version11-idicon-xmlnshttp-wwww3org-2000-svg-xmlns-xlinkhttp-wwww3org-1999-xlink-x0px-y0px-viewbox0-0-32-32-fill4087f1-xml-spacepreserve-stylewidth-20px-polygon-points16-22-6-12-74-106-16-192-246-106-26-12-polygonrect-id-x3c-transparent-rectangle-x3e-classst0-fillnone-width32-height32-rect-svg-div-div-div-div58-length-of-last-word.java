class Solution {
    public int lengthOfLastWord(String s) {
        int i=0,n=s.length(),j=n-1;
        while(i<n){
            if(s.charAt(i)==' ') i++;
            else break;
        }
        while(j>=0){
            if(s.charAt(j)==' ') j--;
            else break;
        }
        String[] parts=s.substring(i,j+1).split(" ");
        return parts[parts.length-1].length(); 
    }
}