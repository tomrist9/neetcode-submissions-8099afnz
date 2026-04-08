class Solution {
   
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int a = stack.pop(); 
                int b = stack.pop(); 
                int result = 0;

                switch (token) {
                    case "+":
                        result = b + a;
                        break;
                    case "-":
                        result = b - a;
                        break;
                    case "*":
                        result = b * a;
                        break;
                    case "/":
                     
                        if (a == 0) throw new ArithmeticException("Division by zero");
                        result = b / a;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
