import java.util.Scanner;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

class Quadrilateral {
    private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;

    public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
    }

    public Point getPoint1() {
        return point1;
    }
    public Point getPoint2() {
        return point2;
    }
    public Point getPoint3() {
        return point3;
    }
    public Point getPoint4() {
        return point4;
    }
}

class Trapezoid extends Quadrilateral {
    public Trapezoid(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }
    public double getArea() {
        Point p1 = getPoint1();
        Point p2 = getPoint2();
        Point p3 = getPoint3();
        Point p4 = getPoint4();

        double area = 0.5 * Math.abs((p1.getY() + p2.getY()) * (p2.getX() - p1.getX()) +
                (p2.getY() + p3.getY()) * (p3.getX() - p2.getX()) +
                (p3.getY() + p4.getY()) * (p4.getX() - p3.getX()) +
                (p4.getY() + p1.getY()) * (p1.getX() - p4.getX()));
        return area;
    }
}

class Parallelogram extends Quadrilateral {
    public Parallelogram(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }
    public double getArea() {
        Point p1 = getPoint1();
        Point p2 = getPoint2();
        Point p3 = getPoint3();

        double area = Math.abs((p1.getX() - p2.getX()) * (p2.getY() - p3.getY()));
        return area;
    }
}

class Rectangle extends Parallelogram {
    public Rectangle(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }
    public double getArea() {
        Point p1 = getPoint1();
        Point p2 = getPoint2();
        
        double area = Math.abs((p2.getX() - p1.getX()) * (p2.getY() - p1.getY()));
        return area;
    }
}

class Square extends Rectangle {
    public Square(Point point1, Point point2, Point point3, Point point4) {
        super(point1, point2, point3, point4);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the x-coordinate of point 1: ");
        int x1 = scanner.nextInt();
        System.out.print("Enter the y-coordinate of point 1: ");
        int y1 = scanner.nextInt();

        System.out.print("Enter the x-coordinate of point 2: ");
        int x2 = scanner.nextInt();
        System.out.print("Enter the y-coordinate of point 2: ");
        int y2 = scanner.nextInt();

        System.out.print("Enter the x-coordinate of point 3: ");
        int x3 = scanner.nextInt();
        System.out.print("Enter the y-coordinate of point 3: ");
        int y3 = scanner.nextInt();

        System.out.print("Enter the x-coordinate of point 4: ");
        int x4 = scanner.nextInt();
        System.out.print("Enter the y-coordinate of point 4: ");
        int y4 = scanner.nextInt();

        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        Point point3 = new Point(x3, y3);
        Point point4 = new Point(x4, y4);

        Quadrilateral quadrilateral = new Quadrilateral(point1, point2, point3, point4);
        Trapezoid trapezoid = new Trapezoid(point1, point2, point3, point4);
        Parallelogram parallelogram = new Parallelogram(point1, point2, point3, point4);
        Rectangle rectangle = new Rectangle(point1, point2, point3, point4);
        Square square = new Square(point1, point2, point3, point4);

        System.out.println("Area of Quadrilateral: -");
        System.out.println("Area of Trapezoid: " + trapezoid.getArea());
        System.out.println("Area of Parallelogram: " + parallelogram.getArea());
        System.out.println("Area of Rectangle: " + rectangle.getArea());
        System.out.println("Area of Square: " + square.getArea());
    }
}
