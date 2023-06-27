import java.util.Scanner;

interface GCD {
    int computeGCD(int num1, int num2);
}

class APPROACH1 implements GCD {
    public int computeGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }
}

class APPROACH2 implements GCD {
    public int computeGCD(int num1, int num2) {
        int minNum = Math.min(num1, num2);
        int gcd = 1;
        for (int i = 1; i <= minNum; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the 1st number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the 2nd number: ");
        int num2 = scanner.nextInt();

        GCD approach1 = new APPROACH1();
        int gcd1 = approach1.computeGCD(num1, num2);
        System.out.println("GCD using Euclid's algorithm - APPROACH 1 : " + gcd1);

        GCD approach2 = new APPROACH2();
        int gcd2 = approach2.computeGCD(num1, num2);
        System.out.println("GCD using factor listing - APPROACH 2 : " + gcd2);
    }
}
