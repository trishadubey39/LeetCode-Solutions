class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
       List<Integer> result = new ArrayList<>();
        for(int i=0; i < expression.length(); i++){
            char curr = expression.charAt(i);
            if (!Character.isDigit(curr)){
                List<Integer> leftParts = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightParts = diffWaysToCompute(expression.substring(i+1));
                evaluate(leftParts, rightParts, curr, result);
            }
        }
        if(isNumeric(expression)) result.add(Integer.valueOf(expression));
        return result;
    }
    
    private boolean isNumeric(String s){
        for(char c : s.toCharArray()) 
            if(!Character.isDigit(c)) return false;
        return true;
    }
    
    private void evaluate(List<Integer> leftParts, List<Integer> rightParts, char operand,             List<Integer> result){
        for(Integer left : leftParts){
            for(Integer right : rightParts){
                if(operand == '+') result.add(left + right);
                else if(operand == '-') result.add(left - right);
                else result.add(left * right);
            }
        }        
    }
}