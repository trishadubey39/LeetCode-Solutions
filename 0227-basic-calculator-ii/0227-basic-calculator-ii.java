class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        char sign='+';
        for(int i=0;i<s.length();i++){
            char x=s.charAt(i);
            if(Character.isDigit(x)){
                int num=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num=num*10 + (s.charAt(i)-'0');
                    i++;
                }
                i--;
                if(sign=='+'){
                    st.push(num);
                }
                else if(sign=='-'){
                    st.push(-num);
                }
                else if(sign=='*'){
                    st.push(st.pop()*num);
                }
                else if(sign=='/'){
                    st.push(st.pop()/num);
                }
            }
            else if(x=='+'){
                sign='+';
            }
            else if(x=='-'){
                sign='-';
            }
            else if(x=='*'){
                sign='*';
            }
            else if(x=='/'){
                sign='/';
            }
            else{
                continue;
            }
        }
        
        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        
        return sum;
     }
}