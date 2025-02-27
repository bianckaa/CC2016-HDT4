import java.util.Scanner;

public class UI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReaderDocument readerDocument = new ReaderDocument();
        Calculator calculator = new Calculator();
        
        System.out.println("Ingrese una expresión infix: ");
        String infixExpression = scanner.nextLine();

        String postfixExpression = readerDocument.infixToPostfix(infixExpression);
        System.out.println("Expresión Postfix: " + postfixExpression);
        
        int result = calculator.evaluatePostfix(postfixExpression);
        System.out.println("Resultado: " + result);
        
        scanner.close();
    }
}
