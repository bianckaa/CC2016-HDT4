import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDocument {

    
    public String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public String infixToPostfix(String infixExpression) {
        IStack<Character> stack = new StackArrayList<>();
        StringBuilder postfix = new StringBuilder();
        
        for (int i = 0; i < infixExpression.length(); i++) {
            char currentChar = infixExpression.charAt(i);
            
            if (Character.isLetterOrDigit(currentChar)) {
                postfix.append(currentChar);
            } 
        
            else if (currentChar == '(') {
                stack.push(currentChar);
            } 
            else if (currentChar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); 
            } 
            else if (isOperator(currentChar)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(currentChar)) {
                    postfix.append(stack.pop());
                }
                stack.push(currentChar);
            }
        }
        
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}
