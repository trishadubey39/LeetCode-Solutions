class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(0,s,0,p);
    }
    private boolean isMatch(int i, String s, int j, String p) { 
        int sn = s.length(), pn = p.length();
        if(j==pn) { 
            return i==sn;    
        }
        char pj = p.charAt(j);
        if(j+1<pn && p.charAt(j+1)=='*') { 
            if(isMatch(i,s,j+2,p)) {
                return true;
            }
            while(i<sn && (pj == '.'||pj==s.charAt(i))) {
                if(isMatch(++i,s,j+2,p)) {
                    return true;
                }
            }
        } else if(i<sn && (s.charAt(i) == pj ||   
                   pj=='.')) {             
            return isMatch(i+1, s, j+1, p);
        }
        return false;  
    }
}