class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sc = new Stack<>();
        Stack<Character> tc = new Stack<>();
        
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)!='#'){
                sc.push(s.charAt(i));
            }else if(!sc.isEmpty()){
                sc.pop();
            }
        }
        
        for(int i =0;i<t.length();i++){
            if(t.charAt(i)!='#'){
                tc.push(t.charAt(i));
            }else if(!tc.isEmpty()){
                tc.pop();
            }
        }
        
        return sc.equals(tc);
    }
}