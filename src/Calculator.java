public class Calculator {

    public int evaluatePostfix(String postfixExpression) {
        IStack<Integer> stack = new StackArrayList<>();
        
        for (int i = 0; i < postfixExpression.length(); i++) {
            char currentChar = postfixExpression.charAt(i);
            
            if (Character.isDigit(currentChar)) {
                stack.push(Character.getNumericValue(currentChar));
            } 
        
            else if (isOperator(currentChar)) {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, currentChar);
                stack.push(result);
            }
        }
        
        return stack.pop(); 
    }

    private int applyOperator(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException("Operador no válido");
        }
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
