package payablesystem;

public class CommissionEmplyee extends Employee {

    private double grossSales;
    private double commisionRate;

    public CommissionEmplyee(String firstName, String lastName, int age, String NIC, double grossSales, double commisionRate) {
        super(firstName, lastName, age, NIC);
        setGrossSales(grossSales);
        setCommisionRate(commisionRate);
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getCommisionRate() {

        return commisionRate;
    }

    public void setCommisionRate(double commisionRate) {
        if (commisionRate > 0 && commisionRate < 1) {
            this.commisionRate = commisionRate;
        } else {
            throw new IllegalArgumentException("Invalid commision rate!");
        }
    }

    
    @Override
    public  double getPaymentAmount()
    {
        return grossSales*commisionRate;
    }
    
    @Override
    public  String toString()
    {
        return
              "\nCommission employee : "+this.getFirstName()+" "+this.getLastName()+ " ("+this.getAge() + " )"+
              "\nNational Identification Number : "+this.getNIC()+
              "\nGross sales : Rs "+String.format("%.2f",this.getGrossSales() )+";"+ " Commission rate : "+String.format("%.2f",this.getCommisionRate())+
              "\nEarned : Rs "+String.format("%.2f",this.getPaymentAmount() );
    }
}
