package payablesystem;

public class Invoice implements Payable {

    private String partNumber;
    private String partDescription;
    private int quantity;
    private double pricePerItem;

    public Invoice(String partNumber, int quantity, double pricePerItem) {
        setPartNumber(partNumber);
        setPartDescription("No description");
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDescription() {
        return partDescription;
    }

    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            //System.out.println("Quantity should be positive!");
            throw new IllegalArgumentException("Quantity should be positive!");
        }
    }

    public double getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(double pricePerItem) {
        if (pricePerItem > 0) {
            this.pricePerItem = pricePerItem;
        } else {
            throw new IllegalArgumentException("Price per item should be positive!");
        }
        
        
    }

    @Override
    public double getPaymentAmount()
    {
        return ( pricePerItem * quantity );
    }
    @Override
    public String toString() {
        return  "\nInvoice : "+
                "\npartNumber : " + partNumber + " (seat)"+ 
                "\nquantity : " + quantity + 
                "\npricePerItem : " + String.format("Rs %.2f", pricePerItem) +
                "\nPayement due : " + String.format("Rs %.2f", getPaymentAmount());
    }

}
