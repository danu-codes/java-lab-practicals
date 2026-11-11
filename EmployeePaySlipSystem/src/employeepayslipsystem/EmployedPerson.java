
package employeepayslipsystem;

public abstract class EmployedPerson extends Person implements IEmployee{
    private String employeeId;
    private String department;
    private char employeeType;
    double basicSalary;
    private double epfAmount;
    private double etfAmount;
    private double payeeTaxAmount;
    private double grossSalary;
    private double netSalary;

    public EmployedPerson(String name, String employeeId, String department, char employeeType, double basicSalary) {
        super(name);
        setEmployeeId(employeeId);
        setDepartment(department);
        setEmployeeType(employeeType);
        setBasicSalary(basicSalary);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        if( employeeId.length() == 6)
        {
        this.employeeId = employeeId;
        }
        else
        {
            System.out.println("Emplyee ID should be has 6 letters!");
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmployeeType() {
        return employeeType == 'P'? "Permanent" : "Temporaly";
    }

    public void setEmployeeType(char employeeType) {
        this.employeeType = Character.toUpperCase(employeeType);
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getEpfAmount() {
        return epfAmount;
    }

    public void setEpfAmount(double epfAmount) {
        this.epfAmount = epfAmount;
    }

    public double getEtfAmount() {
        return etfAmount;
    }

    public void setEtfAmount(double etfAmount) {
        this.etfAmount = etfAmount;
    }

    public double getPayeeTaxAmount() {
        return payeeTaxAmount;
    }

    public void setPayeeTaxAmount(double payeeTaxAmount) {
        this.payeeTaxAmount = payeeTaxAmount;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
    
    @Override
    public void calEPF()
    {
        epfAmount = basicSalary * EPF_RATE;
        //setEpfAmount(epfAmount);
    }
    
    @Override
    public void calETF()
    {
        etfAmount = basicSalary * ETF_RATE;
        //setEtfAmount(etfAmount);
    }
    
    @Override
    public void calPayeeTax()
    {
        if( grossSalary > 150000)
        {
            payeeTaxAmount = grossSalary * 0.08;
        }
        else if( grossSalary > 100000)
        {
            payeeTaxAmount = grossSalary * 0.05;
        }
        else if( grossSalary > 75000)
        {
            payeeTaxAmount = grossSalary * 0.03;
        }
        else
        {
            payeeTaxAmount = 0;
        }
    }

    @Override
    public void calNetSalary()
    {
        calEPF();
        calETF();
        calPayeeTax();
        netSalary = grossSalary - epfAmount - etfAmount - payeeTaxAmount;
    }
}
