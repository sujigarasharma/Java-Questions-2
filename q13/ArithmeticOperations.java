import java.util.Scanner;
import pack1.*;
import pack1.subpack1.*;

public class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();

        //sum pack1
        Sum sum = new Sum();
        double sumResult = sum.calculate(num1, num2);
        System.out.println("Sum: " + sumResult);

        //difference pack1
        Difference difference = new Difference();
        double diffResult = difference.calculate(num1, num2);
        System.out.println("Difference: " + diffResult);

        //product pack1/subpack1
        Product product = new Product();
        double productResult = product.calculate(num1, num2);
        System.out.println("Product: " + productResult);

        //quotient pack1/subpack1
        Quotient quotient = new Quotient();
        double quotientResult = quotient.calculate(num1, num2);
        System.out.println("Quotient: " + quotientResult);
    }
}
