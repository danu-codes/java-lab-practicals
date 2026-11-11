
package hospitalmanagementsystem;

public class Patient extends Person{
    private String illness;

    public Patient(String id, String name, int birthYear, String illness) {
        super(id, name, birthYear);
        setIllness(illness);
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }
    
    @Override
    public void displayDetails()
    {
        System.out.println("Patient : ");
        super.displayBasicDetails();
        System.out.println("Illness  : "+illness);
    }
}
