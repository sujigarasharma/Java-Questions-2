import java.util.Scanner;

class Line {
    private double x1, y1, x2, y2;

    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public double computeLength() {
        double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return length;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the x1 value: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter the y1 value: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter the x2 value: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter the y2 value: ");
        double y2 = scanner.nextDouble();

        Line line = new Line(x1, y1, x2, y2);

        double length = line.computeLength();
        System.out.println("Length of the line: " + length);
    }
}
