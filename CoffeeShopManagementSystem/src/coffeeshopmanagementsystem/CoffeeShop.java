package coffeeshopmanagementsystem;

public class CoffeeShop {

    private MenuItem[] menu;
    private int menuCount;

    public CoffeeShop(int maxMenuItems) {
        menu = new MenuItem[maxMenuItems];
        menuCount = 0;
    }

    public void addMenuItem(MenuItem item) {
        if (menuCount < menu.length) {
            menu[menuCount++] = item;
        } else {
            System.out.println("Menu is full!");
        }
    }

    public void displayMenu() {
        System.out.println("Menu");
        for (int index = 0; index < menuCount; index++) {
            System.out.printf("%d. %-12s Rs %.2f%n", index + 1, menu[index].getItemName(), menu[index].getItemPrice());
        }
    }

    // index is the menu number shown to the customer (starts from 1)
    public MenuItem getMenuItem(int index) {
        if (index >= 1 && index <= menuCount) {
            return menu[index - 1];
        }
        return null;
    }
}
