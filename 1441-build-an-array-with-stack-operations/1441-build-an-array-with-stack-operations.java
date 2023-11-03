class Solution {
    public List<String> buildArray(int[] target, int n) {
        int len=target.length;
        List<String> ans=new ArrayList<>();
        int i=0;  
        int j=1;   
        
        while(i<len && j<=n){
            if(target[i]==j){
                ans.add("Push");
                 i++;
            }
            else{
                ans.add("Push");
                ans.add("Pop");
            }
           
            j++;
        }
        return ans;
    }
}