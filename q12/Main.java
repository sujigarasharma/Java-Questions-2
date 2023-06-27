import java.util.Scanner;

abstract class Special {
    public abstract double process(double P, double R);
}
class Discount extends Special {
    public double process(double P, double R) {
        double total = P + (P * R / 100);
        return total;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the price : ");
        double price = scanner.nextDouble();

        System.out.print("Enter the discount rate : ");
        double rate = scanner.nextDouble();

        Discount discount = new Discount();
        double total = discount.process(price, rate);

        System.out.println("Total after the discount: " + total);
    }
}