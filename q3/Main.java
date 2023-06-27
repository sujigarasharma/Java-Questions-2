import java.util.Scanner;

class ElectricityBill {
    private int consumerNum;
    private String consumerName;
    private int preMonthReading;
    private int curMonthReading;
    private String ConnectionType;

    public ElectricityBill(int consumerNum, String consumerName, int preMonthReading, int curMonthReading, String ConnectionType) {
        this.consumerNum = consumerNum;
        this.consumerName = consumerName;
        this.preMonthReading = preMonthReading;
        this.curMonthReading = curMonthReading;
        this.ConnectionType = ConnectionType;
    }

    public void calculateBillAmount() {
        int units = curMonthReading - preMonthReading;
        double billAmount = 0.0;

        if (ConnectionType.equalsIgnoreCase("domestic")) {
            if (units <= 100) {
                billAmount = units * 1.0;
            } else if (units <= 200) {
                billAmount = 100 * 1.0 + (units - 100) * 2.50;
            } else if (units <= 500) {
                billAmount = 100 * 1.0 + 100 * 2.50 + (units - 200) * 4.0;
            } else {
                billAmount = 100 * 1.0 + 100 * 2.50 + 300 * 4.0 + (units - 500) * 6.0;
            }
        } else if (ConnectionType.equalsIgnoreCase("commercial")) {
            if (units <= 100) {
                billAmount = units * 2.0;
            } else if (units <= 200) {
                billAmount = 100 * 2.0 + (units - 100) * 4.50;
            } else if (units <= 500) {
                billAmount = 100 * 2.0 + 100 * 4.50 + (units - 200) * 6.0;
            } else {
                billAmount = 100 * 2.0 + 100 * 4.50 + 300 * 6.0 + (units - 500) * 7.0;
            }
        }

        System.out.println("Consumer Number: " + consumerNum);
        System.out.println("Consumer Name: " + consumerName);
        System.out.println("Previous Month Reading: " + preMonthReading);
        System.out.println("Current Month Reading: " + curMonthReading);
        System.out.println("Type of EB Connection: " + ConnectionType);
        System.out.println("Units Consumed: " + units);
        System.out.println("Bill Amount: Rs. " + billAmount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Consumer Number: ");
        int consumerNum = scanner.nextInt();

        System.out.print("Enter Consumer Name: ");
        String consumerName = scanner.next();

        System.out.print("Enter Previous Month Reading: ");
        int preMonthReading = scanner.nextInt();

        System.out.print("Enter Current Month Reading: ");
        int curMonthReading = scanner.nextInt();

        System.out.print("Enter Type of EB Connection (domestic/commercial): ");
        String ConnectionType = scanner.next();

        ElectricityBill bill = new ElectricityBill(consumerNum, consumerName, preMonthReading, curMonthReading, ConnectionType);
        bill.calculateBillAmount();
    }
}
