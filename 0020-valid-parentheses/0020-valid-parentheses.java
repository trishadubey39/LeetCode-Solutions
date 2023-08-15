class Solution {
    public boolean isValid(String s) {
         Stack<Character> stack = new Stack<Character>(); 
         if(s.length()==1){
             return false;
         }
        for (char c : s.toCharArray()) { 
            if (c == '(') 
                stack.push(')'); 
            else if (c == '{') 
                stack.push('}'); 
            else if (c == '[')
                stack.push(']'); 
            else if (stack.isEmpty() || stack.pop() != c) 
                return false;
        }
        return stack.isEmpty();
    }
}