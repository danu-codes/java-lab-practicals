
package employeepayslipsystem;

public class TemporalyEmployee extends EmployedPerson{
    private int workingDays;
    private double additionalIncome;
    private double totalDeduction;
    
    

    public TemporalyEmployee(String name, String employeeId, String department, char employeeType, int workingDays) {
        super(name, employeeId, department, employeeType, workingDays*DALY_PAY_AMOUNT);
        setWorkingDays(workingDays);
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }
    
    @Override
    public void calGrossSalary()
    {
        
        if( workingDays>MIN_WORKING_DAYS_PER_MONTH )
        {
            additionalIncome = basicSalary * 0.15;
        }
        else
        {
            additionalIncome = 0;
        }
        
        setGrossSalary(basicSalary+additionalIncome);
    }
    
    @Override
    public String toString() {
        
        totalDeduction = getEpfAmount() + getEtfAmount() + getPayeeTaxAmount();
        setNetSalary(getGrossSalary() - totalDeduction);
        return "\n------------------------------------------\n"+
               "Pay Slip\n"+
               "------------------------------------------\n" +
               "Employee Name : "+getName()+
               "\nEmployee Number : "+getEmployeeId()+
                "\nDepartment : "+getDepartment()+
                "\nEmployee type : "+getEmployeeType()+
                "\n------------------------------------------\n" +
                "Earnings\n"+
                "------------------------------------------\n" +
                "\nBasic Salary : "+basicSalary+
                "\nAllowance : "+additionalIncome+
                "\nGross Pay : "+getGrossSalary()+
                "\n------------------------------------------\n" +
                "Deductions\n"+
                "------------------------------------------\n" +
                "EPF : "+getEpfAmount()+
                "\nETF : "+getEtfAmount()+
                "\nPayee Tax : "+getPayeeTaxAmount()+
                "\nTotalDeduction : "+totalDeduction+
                "\n------------------------------------------\n" +
                "Net Pay : "+getNetSalary()+
                "\n------------------------------------------\n" 
                ;
    }
}
