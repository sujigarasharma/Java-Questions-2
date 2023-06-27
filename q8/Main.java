import java.util.Scanner;

class ProductData {
    private String productName;
    private double costPrice;
    private double sellingPrice;

    public ProductData(String productName, double costPrice, double sellingPrice) {
        this.productName = productName;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
    }
    public void printProduct() {
        System.out.println("Product: " + productName);
        System.out.println("Cost Price: " + costPrice);
        System.out.println("Selling Price: " + sellingPrice);
    }
    public double getCostPrice() {
        return costPrice;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }
}
class ProfitLossCalculation extends ProductData {
    public ProfitLossCalculation(String productName, double costPrice, double sellingPrice) {
        super(productName, costPrice, sellingPrice);
    }
    public void calculate() {
        double costPrice = getCostPrice();
        double sellingPrice = getSellingPrice();

        double profit = sellingPrice - costPrice;
        if (profit > 0) {
            System.out.println("Profit: " + profit);
        } else if (profit < 0) {
            System.out.println("Loss: " + (-profit));
        } else {
            System.out.println("No profit or loss");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();

        ProfitLossCalculation[] products = new ProfitLossCalculation[numProducts];

        for (int i = 0; i < numProducts; i++) {
            System.out.println("\nProduct " + (i + 1));
            System.out.print("Enter the product name: ");
            String productName = scanner.next();

            System.out.print("Enter the cost price: ");
            double costPrice = scanner.nextDouble();

            System.out.print("Enter the selling price: ");
            double sellingPrice = scanner.nextDouble();

            products[i] = new ProfitLossCalculation(productName, costPrice, sellingPrice);
        }
        for (int i = 0; i < numProducts; i++) {
            System.out.println("\nProduct " + (i + 1) + " details:");
            products[i].printProduct();
            products[i].calculate();
        }
    }
}
