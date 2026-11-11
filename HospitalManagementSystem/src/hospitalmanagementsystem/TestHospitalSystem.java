package hospitalmanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class TestHospitalSystem {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        List<Person> list = new ArrayList<Person>();
        int choice;
        do {
            System.out.println("\nHospital Management System");
            System.out.println("1. Add doctor");
            System.out.println("2. Add Nurse");
            System.out.println("3. Add Patient");
            System.out.println("4. Display All Details");
            System.out.println("5. scheduleShift");
            System.out.println("6. cancelShift");
            System.out.println("7. Exit");

            System.out.print("Enter choice : ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter id : ");
                    String id = input.nextLine();

                    System.out.print("Enter name : ");
                    String name = input.nextLine();

                    System.out.print("Enter birth year : ");
                    int birthYear = input.nextInt();

                    if (choice == 1) {
                        input.nextLine();

                        System.out.print("Enter specialty : ");
                        String specialty = input.nextLine();

                        addDoctor(list, id, name, birthYear, specialty);
                    } else if (choice == 2) {
                        input.nextLine();
                        System.out.print("Enter shift (leave blank to skip) : ");
                        String shift = input.nextLine();

                        addNurse(list, id, name, birthYear, shift);
                    } else {
                        input.nextLine();
                        System.out.print("Enter illness : ");
                        String illness = input.nextLine();

                        addPatient(list, id, name, birthYear, illness);
                    }
                    break;
                case 4:
                    displayAllDetails(list);
                    break;
                case 5:
                    System.out.print("Enter id : ");
                    String personId = input.nextLine();

                    System.out.print("Enter shift : ");
                    String shift = input.nextLine();

                    scheduleShift(list, personId, shift);

                    break;
                case 6:
                    System.out.print("Enter id : ");
                    personId = input.nextLine();

                    System.out.print("Enter shift : ");
                    shift = input.nextLine();

                    cancelScheduleShift(list, personId, shift);
                    break;
                case 7:
                    System.out.println("\nProgram terminated!");
                    break;
                default:
                    System.out.println("\nInvalid input!");
                    break;
            }

        } while (choice != 7);
    }

    public static void addDoctor(List<Person> list, String id, String name, int birthYear, String specialty) {
        Doctor doctor = new Doctor(id, name, birthYear, specialty);
        list.add(doctor);
        System.out.println("Doctor " + doctor.getName() + "'s details added !");
    }

    public static void addNurse(List<Person> list, String id, String name, int birthYear, String shifts) {
        Nurse nurse = new Nurse(id, name, birthYear);
        list.add(nurse);
        if (shifts != null && !shifts.trim().isEmpty()) {
            nurse.scheduleShift(shifts);
        }
        System.out.println("Nurse " + nurse.getName() + "'s details added !");
    }

    public static void addPatient(List<Person> list, String id, String name, int birthYear, String illness) {
        Patient patient = new Patient(id, name, birthYear, illness);
        list.add(patient);
        System.out.println("Patient " + patient.getName() + "'s details added !");
    }

    public static void displayAllDetails(List<Person> person) {
        if (person.isEmpty()) {
            System.out.println("No records registered!");
            return;
        }
        System.out.println("\n========All details========");
        for (Person object : person) {
            object.displayDetails();

        }
    }

    public static void scheduleShift(List<Person> people, String personId, String shift) {
        for (Person person : people) {
            if (person.getId().equals(personId)) {
                if (person instanceof Schedulable) {
                    ((Schedulable) person).scheduleShift(shift);
                } else {
                    System.out.println(person.getName() + " cannot be scheduled for shifts!");
                }
                return;
            }
        }
        System.out.println("No person found with id " + personId);
    }

    public static void cancelScheduleShift(List<Person> people, String personId, String shift) {
        for (Person person : people) {
            if (person.getId().equals(personId)) {
                if (person instanceof Schedulable) {
                    ((Schedulable) person).cancelShift(shift);
                } else {
                    System.out.println(person.getName() + " has no shifts to cancel!");
                }
                return;
            }
        }
        System.out.println("No person found with id " + personId);
    }
}
