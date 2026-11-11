package payablesystem;

public abstract class Employee implements Payable {

    private String firstName;
    private String lastName;
    private int age;
    private String NIC;

    public Employee(String firstName, String lastName, int age, String NIC) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setNIC(NIC);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 18 && age <= 60) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age should be between 18 to 60!");
        }
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    
     public abstract double getPaymentAmount();
    
     public abstract String toString();
}
