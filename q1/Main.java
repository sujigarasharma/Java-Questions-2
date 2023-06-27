import java.util.Scanner;

class Circle {
    private double radius;
    public Circle() {
        radius = 0.0;
    }
    public Circle(double radius) {
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public double findArea() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        Circle circle = new Circle(radius);

        System.out.println("Radius: " + circle.getRadius());
        System.out.println("Area: " + circle.findArea());

        scanner.close();
    }
}
