package employeepayslipsystem;

public class PermanentEmployee extends EmployedPerson {

    private int OTHourses;
    private double overTimeAmount;
    private double totalDeduction;
 

    public PermanentEmployee(String name, String employeeId, String department, char employeeType, double basicSalary, int OTHourses) {
        super(name, employeeId, department, employeeType, basicSalary);
        setOTHourses(OTHourses);
    }

    public int getOTHourses() {
        return OTHourses;
    }

    public void setOTHourses(int OTHourses) {
        if( OTHourses >= 0 && OTHourses <= MAX_OT_HOURS_PER_MONTH )
        {
            this.OTHourses = OTHourses;
        }
        else
        {
            System.out.println("OT hours should be between 0 and " + MAX_OT_HOURS_PER_MONTH + "!");
        }
    }

    @Override
    public void calGrossSalary() {
        overTimeAmount = OTHourses * OT_RATE;
        this.setGrossSalary(this.getBasicSalary() + overTimeAmount);
    }

    @Override
    public String toString() {
        
        totalDeduction = getEpfAmount() + getEtfAmount() + getPayeeTaxAmount();
        setNetSalary(getGrossSalary() - totalDeduction) ;
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
                "\nBasic Salary : "+getBasicSalary()+
                "\nOvertime Hours : "+OTHourses+
                "\nOvertime Amount : "+overTimeAmount+
                "\nGross Pay : "+getGrossSalary()+
                "\n------------------------------------------\n" +
                "Deductions\n"+
                "------------------------------------------\n" +
                "\nEPF : "+getEpfAmount()+
                "\nETF : "+getEtfAmount()+
                "\nPayee Tax : "+getPayeeTaxAmount()+
                "\nTotalDeduction : "+totalDeduction+
                "\n------------------------------------------\n" +
                "Net Pay : "+getNetSalary()+
                "\n------------------------------------------\n" 
                ;
    }

}
