import java.util.Stack;

public class Translator {

    private IStack<Double> stack;

    public Translator(IStack<Double> stack) {
        this.stack = stack;
    }

    public String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> operators = new Stack<>();
        StringBuilder number = new StringBuilder();

        // Recorrer cada caracter de la expresión infix
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // Si el caracter es un número
            if (Character.isDigit(ch)) {
                number.append(ch); // Acumula el número completo (en caso de varios dígitos)
            } else {
                if (number.length() > 0) {
                    // Si hay un número acumulado, añádelo a postfix y resetea el StringBuilder
                    postfix.append(number).append(" ");
                    number.setLength(0); // Reinicia el número acumulado
                }

                // Si el caracter es un operador, manejar la pila de operadores
                if (ch == '(') {
                    operators.push(ch);
                } else if (ch == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        postfix.append(operators.pop()).append(" ");
                    }
                    operators.pop(); // Elimina '(' de la pila
                } else if (isOperator(ch)) {
                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                        postfix.append(operators.pop()).append(" ");
                    }
                    operators.push(ch);
                }
            }
        }

        // Añadir el último número si lo hay
        if (number.length() > 0) {
            postfix.append(number).append(" ");
        }

        // Añadir los operadores restantes
        while (!operators.isEmpty()) {
            postfix.append(operators.pop()).append(" ");
        }

        return postfix.toString().trim(); // Elimina el espacio extra final
    }

    // Método para verificar si un caracter es un operador
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Método para obtener la precedencia de los operadores
    private int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        }
        if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }
}
