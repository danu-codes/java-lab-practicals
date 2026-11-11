package payablesystem;

public class HourlyEmployee extends Employee {

    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, int age, String NIC, double wage, double hours) {
        super(firstName, lastName, age, NIC);
        setWage(wage);
        setHours(hours);
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        if (wage > 0) {
            this.wage = wage;
        } else {
            throw new IllegalArgumentException("Wage should be positive!");
        }
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        if (hours > 0 && hours < 168) {
            this.hours = hours;
        } else {
            throw new IllegalArgumentException("hours should be positive!");
        }
    }

    @Override
    public double getPaymentAmount()
    {
        if( hours>40)
        {
           return ( ( 40 * wage) +  ( hours-40 )*1.5*wage); 
        }
        else{
         return (hours * wage);
        }
    }

    @Override
    public String toString() {
      return
              "\nHourly employee : "+this.getFirstName()+" "+this.getLastName()+ " ("+this.getAge() + " )"+
              "\nNational Identification Number : "+this.getNIC()+
              "\nHourly wage : Rs "+String.format("%.2f",this.getWage() )+";"+ " Hourse worked : "+String.format("%.2f",this.getHours() )+
              "\nEarned : Rs "+String.format("%.2f",this.getPaymentAmount() );
        
    }

}
