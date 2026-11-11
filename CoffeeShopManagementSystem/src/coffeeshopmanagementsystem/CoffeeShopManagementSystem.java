package coffeeshopmanagementsystem;

import java.util.Scanner;

public class CoffeeShopManagementSystem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // NOTE: prices and stock are sample values - change them to match your question
        CoffeeShop shop = new CoffeeShop(4);
        shop.addMenuItem(new MenuItem("Tea", 150.00, 20));
        shop.addMenuItem(new MenuItem("Coffee", 250.00, 20));
        shop.addMenuItem(new MenuItem("Milk", 200.00, 20));
        shop.addMenuItem(new MenuItem("Cappuccino", 350.00, 20));

        shop.displayMenu();
        System.out.print("Enter the item number : ");
        int select = input.nextInt();
        input.nextLine();
        System.out.print("Enter your name : ");
        String cName = input.nextLine();
        System.out.print("Enter the quantity : ");
        int quantity = input.nextInt();

        Order order = new Order(cName, 10);
        order.addItems(shop.getMenuItem(select), quantity);
        order.printOrderSummary();
    }
}
