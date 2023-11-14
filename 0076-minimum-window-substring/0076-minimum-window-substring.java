class Solution {
    static String ans="";
    
    public boolean compare(int a[],int b[]) {
        int p1=0,p2=0;
        while(p1<52 && p2<52){
            if(a[p1]<b[p2]) return false;
            else{
                p1++;
                p2++;
            }
        }
        return true;
    }
    public boolean solve(String s,int b[],int k) {
        int i=0,j=0;
        int a[]=new int[52];
        while(j<s.length()) {
            if(s.charAt(j)>=65 && s.charAt(j)<=91){
                a[s.charAt(j)-'A'+26]++;
            }
            else{
            a[s.charAt(j)-'a']++;
            }
            if(j-i+1 == k) {
                if(compare(a,b)){
                    ans=s.substring(i,j+1);
                    return true;
                }
                
                if(s.charAt(i)>=65 && s.charAt(i)<=91){
                    a[s.charAt(i)-'A'+26]--;
                }else{
                a[s.charAt(i)-'a']--;
                }
                i++;
            }

            
            
            j++;
        }
        //if(compare(a,b)) return true;
        return false;
    }
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        if(s.length() == t.length() && s.equals(t)) return t;
        int b[]=new int[52];
        ans="";
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)>= 65 && t.charAt(i)<=91){
                b[t.charAt(i)-'A'+26]++;
            }
            else{
            b[t.charAt(i)-'a']++;
            }
        }
        //for(int i=0;i<52;i++) System.out.print(b[i]+" ");

        int i=t.length(),j=s.length();
        while(i<=j) {
            int mid=(i+j)/2;
           
            if(solve(s,b,mid)){
                 System.out.print(mid+" ");
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return ans;
    }
}