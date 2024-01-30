class Solution {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() == 1 && tokens[i].charAt(0) < 48) {
                int sec = stack.pop();
                int first = stack.pop();
                stack.push(performAlgo(first, sec, tokens[i]));
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop().intValue();
    }

    public int performAlgo(int first, int sec, String op) {
        int result = 0;
        switch (op) {
            case "+":
                result = first + sec;
                break;
            case "*":
                result = first * sec;
                break;
            case "/":
                result = first / sec;
                break;
            case "-":
                result = first - sec;
                break;
        }
        return result;
    }
}