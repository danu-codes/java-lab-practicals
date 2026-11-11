
package hospitalmanagementsystem;

public abstract class Person {
    private String id;
    private String name;
    private int birthYear;

    public Person(String id, String name, int birthYear) {
        setId(id);
        setName(name);
        setBirthYear(birthYear);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    
    public final int calculateAge()
    {
        return java.time.Year.now().getValue() - birthYear;
    }
    
    protected void displayBasicDetails()
    {
        System.out.println("id   : "+id);
        System.out.println("name :"+name);
        System.out.println("age  :"+this.calculateAge());
    }
    
    public abstract void displayDetails();
  
}
