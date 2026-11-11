package coffeeshopmanagementsystem;

public class Order {

    private String customerName;
    private MenuItem[] orderedItems;
    private int[] quantities;
    private int itemCount;
    private double totalAmount;

    public Order(String customerName, int maxItems) {
        this.customerName = customerName;
        orderedItems = new MenuItem[maxItems];
        quantities = new int[maxItems];
        itemCount = 0;
        totalAmount = 0;
    }

    public void addItems(MenuItem item, int quantity) {
        if (item == null) {
            System.out.println("Invalid menu item!");
        } else if (quantity <= 0) {
            System.out.println("Quantity should be positive!");
        } else if (itemCount >= orderedItems.length) {
            System.out.println("Order is full!");
        } else if (item.getStock() < quantity) {
            System.out.println("Insufficient stock for the " + item.getItemName());
        } else {
            item.reduceStock(quantity);
            orderedItems[itemCount] = item;
            quantities[itemCount] = quantity;
            itemCount++;
            totalAmount += item.getItemPrice() * quantity;
        }
    }

    public void printOrderSummary() {
        System.out.println("\nOrder Summary");
        System.out.println("Customer : " + customerName);
        for (int index = 0; index < itemCount; index++) {
            System.out.printf("%-12s x %d = Rs %.2f%n", orderedItems[index].getItemName(), quantities[index],
                    orderedItems[index].getItemPrice() * quantities[index]);
        }
        System.out.printf("Total    : Rs %.2f%n", totalAmount);
    }
}
