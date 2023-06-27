import java.util.Scanner;

class ComplexArithmetic  {
    private double real;
    private double imaginary;

    public ComplexArithmetic (double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public ComplexArithmetic  add(ComplexArithmetic  other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new ComplexArithmetic (newReal, newImaginary);
    }

    public ComplexArithmetic  subtract(ComplexArithmetic  other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new ComplexArithmetic (newReal, newImaginary);
    }

    public ComplexArithmetic  multiply(ComplexArithmetic  other) {
        double newReal = this.real * other.real - this.imaginary * other.imaginary;
        double newImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexArithmetic(newReal, newImaginary);
    }

    public ComplexArithmetic  divide(ComplexArithmetic  other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double newReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double newImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexArithmetic (newReal, newImaginary);
    }

    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
}

public class ComplexMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the real of the 1st complex number: ");
        double real1 = scanner.nextDouble();
        System.out.print("Enter the imaginary of the 1st complex number: ");
        double imaginary1 = scanner.nextDouble();
        ComplexArithmetic complex1 = new ComplexArithmetic(real1, imaginary1);

        System.out.print("Enter the real of the 2nd complex number: ");
        double real2 = scanner.nextDouble();
        System.out.print("Enter the imaginary of the 2nd complex number: ");
        double imaginary2 = scanner.nextDouble();
        ComplexArithmetic complex2 = new ComplexArithmetic(real2, imaginary2);

        System.out.println("\nComplex Number 1: " + complex1);
        System.out.println("Complex Number 2: " + complex2);

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Complex Numbers");
            System.out.println("2. Subtract Complex Numbers");
            System.out.println("3. Multiply Complex Numbers");
            System.out.println("4. Divide Complex Numbers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            ComplexArithmetic result;
            switch (choice) {
                case 1:
                    result = complex1.add(complex2);
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = complex1.subtract(complex2);
                    System.out.println("Result: " + result);
                    break;
                case 3:
                    result = complex1.multiply(complex2);
                    System.out.println("Result: " + result);
                    break;
                case 4:
                    result = complex1.divide(complex2);
                    System.out.println("Result: " + result);
                    break;
                case 5:
                    System.out.println("Exit.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
