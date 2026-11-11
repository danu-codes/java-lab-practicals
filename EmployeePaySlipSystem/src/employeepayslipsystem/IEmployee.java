
package employeepayslipsystem;

public interface IEmployee {
    public final static double OT_RATE = 425.00;
    public final static int MAX_OT_HOURS_PER_MONTH = 80;
    public final static int MIN_WORKING_DAYS_PER_MONTH = 20;
    public final static double DALY_PAY_AMOUNT = 2500.00;
    public final static double EPF_RATE = 0.03;
    public final static double ETF_RATE = 0.05;
    
    public abstract void calEPF();
    public abstract void calETF();
    public abstract void calPayeeTax();
    public abstract void calGrossSalary();
    public abstract void calNetSalary();
}
