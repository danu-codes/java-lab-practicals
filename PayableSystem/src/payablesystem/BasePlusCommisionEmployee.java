package payablesystem;

public class BasePlusCommisionEmployee extends CommissionEmplyee {

    private double baseSalary;

    public BasePlusCommisionEmployee(String firstName, String lastName, int age, String NIC, double grossSales, double commisionRate, double baseSalary) {
        super(firstName, lastName, age, NIC, grossSales, commisionRate);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary > 0) {
            this.baseSalary = baseSalary;
        } else {
            throw new IllegalArgumentException("Base salary should be positive!");
        }
    }
    
    @Override
    public  double getPaymentAmount()
    {
        return ( baseSalary + this.getGrossSales() * this.getCommisionRate() );
    }
    
    @Override
    public  String toString()
    {
        return
              "\nBase-salaried commission employee : "+this.getFirstName()+" "+this.getLastName()+ " ("+this.getAge() + " )"+
              "\nNational Identification Number : "+this.getNIC()+
              "\nGross sales : Rs "+String.format("%.2f",this.getGrossSales() )+";"+ " Commission rate : "+String.format("%.2f",this.getCommisionRate())+
              "\nBase salary : Rs "+String.format("%.2f",this.baseSalary )+
              "\nPayment due : Rs "+String.format("%.2f",this.getPaymentAmount() );
    }

}
