
package hospitalmanagementsystem;

public final class  Administrator extends Person{
    private String department;

    public Administrator(String id, String name, int birthYear, String department) {
        super(id, name, birthYear);
        setDepartment(department);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public void displayDetails()
    {
        super.displayBasicDetails();
        System.out.println("Department : "+department);
    }
    
    public final void adminAccess()
    {
        System.out.println("Administrator access granted.");
    }
}
