class Solution {
    public int countBinarySubstrings(String s) {
        int i=1, curr =1, prev =0, count =0;
        while(i<s.length()){
            if(s.charAt(i-1)!=s.charAt(i)){
                count+=Math.min(prev,curr);
                prev = curr;
                curr =1;
            }else{
                curr ++;
            }
            
            i++;
        }
        return count+= Math.min(prev,curr);
    }
}