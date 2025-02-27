import java.util.Stack;

public class Translator {

    private int preced(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;  
        } else if (ch == '*' || ch == '/') {
            return 2;  
        } else if (ch == '^') {
            return 3;  
        } else {
            return 0;  
        }
    }

    public String infixToPostfix(String infix) {
        Stack<Character> stk = new Stack<>();
        stk.push('#');  
        StringBuilder postfix = new StringBuilder();  

        for (int i = 0; i < infix.length(); i++) {
            char currentChar = infix.charAt(i);

            if (Character.isWhitespace(currentChar)) {
                continue; // Ignorar espacios en blanco
            }

            if (Character.isLetterOrDigit(currentChar)) {
                postfix.append(currentChar);  
            } else if (currentChar == '(') {
                stk.push('(');  
            } else if (currentChar == ')') {
                while (stk.peek() != '#' && stk.peek() != '(') {
                    postfix.append(stk.pop());
                }
                if (stk.peek() == '(') {
                    stk.pop();  
                } else {
                    throw new IllegalArgumentException("Error: Paréntesis desbalanceados.");
                }
            } else {
                // Manejar el operador de potencia (asociatividad derecha)
                if (currentChar == '^') {
                    stk.push(currentChar); 
                } else {
                    while (stk.peek() != '#' && preced(currentChar) <= preced(stk.peek())) {
                        postfix.append(stk.pop());  
                    }
                    stk.push(currentChar);  
                }
            }
        }

        while (stk.peek() != '#') {
            if (stk.peek() == '(') {
                throw new IllegalArgumentException("Error: Paréntesis desbalanceados.");
            }
            postfix.append(stk.pop());
        }

        return postfix.toString();
    }
}

 