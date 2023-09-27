class Solution {
    public String decodeAtIndex(String s, int k) {
        int currlen = 0 ;
        for(int i=0;i<k;i++){
            char c = s.charAt(i);
            if(c<='9'&&c>='0'){
                int n = c-'0';
                
                if(1L*k>(1L*currlen*n)){
                    currlen=currlen*n;
                    continue;
                }else{
                    int x = k%currlen;
                    if(x==0){
                        x=(int)currlen;
                    }
                    return decodeAtIndex(s,x);
                }
            }else{
                currlen++;
                if(currlen==(k)){
                    return String.valueOf(c);
                }
                

            }
        }
        return "";
    }
}