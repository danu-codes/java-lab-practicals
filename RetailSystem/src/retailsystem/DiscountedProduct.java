
package retailsystem;

class DiscountedProduct extends Product{
    private double discountPercentage;

    public DiscountedProduct(double discountPercentage, String productName, double price) {
        super(productName, price);
        setDiscountPercentage(discountPercentage);
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            this.discountPercentage = discountPercentage;
        } else {
            System.out.println("Discount should be between 0 and 100!");
        }
    }
    
    public double getDiscountedPrice()
    {
        return (getPrice() - (discountPercentage/100)*getPrice());
    }
    
    @Override
    public void displayDetails()
    {
        super.displayDetails();
        System.out.println("Discount      : "+discountPercentage+"%");
        System.out.println("Discounted Price : "+getDiscountedPrice());
    }
}
