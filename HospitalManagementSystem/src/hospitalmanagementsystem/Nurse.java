package hospitalmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person implements Schedulable {

    private List<String> shifts = new ArrayList<>();

    public Nurse(String id, String name, int birthYear) {
        super(id, name, birthYear);
    }

    public List<String> getShifts() {
        return shifts;
    }

    public void setShifts(List<String> shifts) {
        this.shifts = shifts;
    }

    @Override
    public void displayDetails() {
        System.out.println("Nurse : ");
        displayBasicDetails();
        System.out.println("Shift : " + this.getShifts());
    }

    @Override
    public void scheduleShift(String shift) {
        if (!shifts.contains(shift)) {
            shifts.add(shift);
            System.out.println("Shift " + shift + " scheduled for Nurse " + getName());
        } else {
            System.out.println("Already scheduled!");
        }
    }

    @Override
    public void cancelShift(String shift) {
        if(shifts.contains(shift))
        {
            shifts.remove(shift);
            System.out.println("Shift " + shift + " canceled for Nurse " + getName());
            
        }
        else
        {
            System.out.println("shift "+shift+" not found!");
        }
    }

}
