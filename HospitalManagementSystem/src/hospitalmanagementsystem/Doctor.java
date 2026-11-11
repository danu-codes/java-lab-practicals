package hospitalmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person implements Schedulable {

    private String specialty;
    private List<String> shifts = new ArrayList<>();

    public List<String> getShifts() {
        return shifts;
    }

    public void setShifts(List<String> shifts) {
        this.shifts = shifts;
    }

    public Doctor(String id, String name, int birthYear, String specialty) {
        super(id, name, birthYear);
        setSpecialty(specialty);
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @Override
    public void displayDetails() {
        System.out.println("Doctor : ");
        super.displayBasicDetails();
        System.out.println("Specialty : " + specialty);
        System.out.println("Shift : "+this.getShifts());
    }

    @Override
    public void scheduleShift(String shift) {
        if (!shifts.contains(shift)) {
            shifts.add(shift);
            System.out.println("Shift " + shift + " scheduled for Doctor " + getName());
        } else {
            System.out.println("Shift " + shift + " is already scheduled for Doctor " + getName());
        }

    }

    @Override
    public void cancelShift(String shift) {
        if (shifts.contains(shift)) {
            shifts.remove(shift);
            System.out.println("Shift " + shift + " canceled for Doctor " + getName());

        } else {
            System.out.println("shift " + shift + " not found!");
        }
    }

}
