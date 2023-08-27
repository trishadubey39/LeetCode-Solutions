class Solution {
    public String convert(String s, int numRows) {
       if(numRows==1){
        return s;
    }
    
    StringBuilder sb= new StringBuilder();
    char[] charArray=s.toCharArray();
    boolean odd=false;
    for(int i=0;i<numRows;i++){
        odd=true;
        for(int j=i;j<s.length();){
            sb.append(charArray[j]);
            if(i==0 || i==numRows-1)
                 j+=(numRows*2-2); 
            else{
                if(odd){
                    j+=(((numRows-i-1)*2));
                    odd=false;
                }else{
                   j+=(2*i);
                   odd=true;
                }
            }           
            if(j>s.length()){
                break;
            }
        }
    }
    return sb.toString();
    }
}