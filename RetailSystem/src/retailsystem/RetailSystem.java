
package retailsystem;

public class RetailSystem {

    public static void main(String[] args) {
       Product p1 = new Product("Pen", 20.00);
       
       p1.displayDetails();
       
       DiscountedProduct dp1 = new DiscountedProduct(10, "bag", 100.00);
       
       dp1.displayDetails();
    }
    
}
