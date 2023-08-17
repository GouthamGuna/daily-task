package in.gmsk.array;

import java.util.Scanner;

public class ShoppingBill {

    /**
     * double price = 10.0;
     * double quantity = 20.0;
     * double gram = 30.0;
     * <p>
     * double result = (price * quantity) / gram;
     * */

    public static void displayBill() {
        Scanner scan = new Scanner(System.in);
        char ch;
        do {
            System.out.print("Enter Item name: ");
            String item = scan.next();
            System.out.print(item+" Enter Quantity: ");
            int qty = scan.nextInt();
            System.out.print("Enter Price per unit: ");
            double price = scan.nextDouble();
            double total = qty * price;
            System.out.println("Total Price: " + total);
            System.out.print("Do you want to continue shopping? (Y/N): ");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }

    public static void main(String[] args) {
        displayBill();
    }
}
