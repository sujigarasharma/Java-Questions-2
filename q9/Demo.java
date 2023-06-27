import java.util.Scanner;

class Card {
    protected Long cardNum;
    protected String custName;
    protected String bankName;

    public Card(Long cardNum, String custName, String bankName) {
        this.cardNum = cardNum;
        this.custName = custName;
        this.bankName = bankName;
    }
}
class CreditCard extends Card {
    private double limit;

    public CreditCard(Long cardNum, String custName, String bankName, double limit) {
        super(cardNum, custName, bankName);
        this.limit = limit;
    }
    public void display() {
        System.out.println("Card Number: " + cardNum);
        System.out.println("Customer Name: " + custName);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Credit Limit: " + limit);
    }
    public void use(double amount) {
        if (amount <= limit) {
            limit -= amount;
            System.out.println("Amount used: " + amount);
            System.out.println("Remaining limit: " + limit);
        } else {
            System.out.println("Insufficient credit limit!");
            System.out.println("Available limit: " + limit);
        }
    }
}
public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of credit cards: ");
        int numCards = scanner.nextInt();

        CreditCard[] creditCards = new CreditCard[numCards];

        for (int i = 0; i < numCards; i++) {
            System.out.println("Enter details for Credit Card " + (i + 1) + ":");

            System.out.print("Card Number: ");
            Long cardNum = scanner.nextLong();
            scanner.nextLine();
            System.out.print("Customer Name: ");
            String custName = scanner.nextLine();
            System.out.print("Bank Name: ");
            String bankName = scanner.nextLine();
            System.out.print("Credit Limit: ");
            double limit = scanner.nextDouble();
            creditCards[i] = new CreditCard(cardNum, custName, bankName, limit);
            System.out.println();
        }

        System.out.println("Credit Card details:");
        for (int i = 0; i < numCards; i++) {
            System.out.println("Credit Card " + (i + 1) + " details:");
            creditCards[i].display();
            System.out.println();
        }
        System.out.println("Using credit cards:");
        for (int i = 0; i < numCards; i++) {
            System.out.println("Credit Card " + (i + 1));
            System.out.print("Enter the amount to use: ");
            double amount = scanner.nextDouble();
            creditCards[i].use(amount);
            System.out.println();
        }
    }
}
