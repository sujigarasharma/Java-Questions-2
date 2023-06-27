import java.util.Scanner;
import pack1.ArithmeticOperations;
import pack2.MathOperations;

class Calculator implements ArithmeticOperations, MathOperations {
    public int add(int a, int b) {
        return a + b;
    }
    public int sub(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int divide(int a, int b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int a = getUserInput("Enter the 1st number: ");
        int b = getUserInput("Enter the 2nd number: ");

        int sum = calculator.add(a, b);
        int difference = calculator.sub(a, b);
        int product = calculator.multiply(a, b);
        int quotient = calculator.divide(a, b);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }
    private static int getUserInput(String message) {
        System.out.print(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
