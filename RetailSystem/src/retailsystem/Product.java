
package retailsystem;

public class Product {
    private String productName;
    private double price;

    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void displayDetails()
    {
        System.out.println("Product Name  : "+getProductName());
        System.out.println("Product Price : "+getPrice());
    }
}
