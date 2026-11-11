package coffeeshopmanagementsystem;

public class MenuItem {

    private String itemName;
    private double itemPrice;
    private int stock;

    public MenuItem(String itemName, double itemPrice, int stock) {
        setItemName(itemName);
        setItemPrice(itemPrice);
        setStock(stock);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void reduceStock(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
        } else {
            System.out.println("Insufficient stock for the " + itemName);
        }
    }
}
