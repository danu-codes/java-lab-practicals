/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospitalroombillingsystem;
import java.util.Scanner;
/**
 *
 * @author ADMIN
 */
public class MainClass {

    public static void main(String[] args) {
        printMainMenu();
    }

    public static void printMainMenu() {
        String userInput;
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();

        do {
            System.out.println("====================Welcome to SightSavers===================");
            System.out.println("=======================Main Menu=============================");
            System.out.println("\t 1.Register a New Patient.");
            System.out.println("\t 2.Enter standard room price.");
            System.out.println("\t 3.Add Treatments to Patients.");
            System.out.println("\t 4.Discharge a Patient.");
            System.out.println("\t 5.Check Room Occupancy");
            System.out.println("\t 6.Display All the Rooms in the Hospital");
            System.out.println("\t 0.Exit");
            System.out.print("\nEnter your choice: ");
            userInput = scanner.next();
            switch (userInput) {
                case "1" -> {
                    regsiterPatient(scanner, hospital);
                    break;
                }
                case "2" -> {
                    setStandardRoomPrice(scanner);
                    break;
                }
                case "3" -> {
                    addTreatmentOfPatients(scanner, hospital);
                    break;
                }
                case "4" -> {
                    dischargePatients(scanner, hospital);
                    break;
                }
                case "5" -> {
                    checkRoomAvailability(scanner, hospital);
                    break;
                }
                case "6" -> {
                    displayAllTheRooms(hospital);
                    break;
                }
                case "0" -> {
                    System.out.println("Thank you for using SightSavers!");
                    userInput = "End";
                    break;
                }
                default -> {
                    System.out.println("Wrong input. Try Again!");
                }
            }
        } while (!"End".equals(userInput));
    }

    public static void regsiterPatient(Scanner scanner, Hospital hospital) {
        String name;
        String nic;
        int doctorId;
        int floorNo;
        int roomNO;
        System.out.print("Enter Name: ");
        name = scanner.next();
        System.out.print("Enter patient's NIC: ");
        nic = scanner.next();
        System.out.print("Enter doctor id (1 - Doctor 1, 2 - Doctor 2, 3 - Doctor 3, 4 - Doctor 4, 5 - Doctor 5): ");
        doctorId = scanner.nextInt();
        System.out.print("On which floor would you like the room? ");
        floorNo = scanner.nextInt();
        System.out.print("Which room would you like on floor No." + floorNo + "? ");
        roomNO = scanner.nextInt();
        hospital.registerPatients(name, nic, doctorId, floorNo, roomNO);
    }

    public static void setStandardRoomPrice(Scanner scanner) {
        double price;
        System.out.print("Enter the standard price of a room:");
        price = scanner.nextDouble();
        if (price > 0) {
            Room.setStandardPrice(price);
            System.out.println("Standard Room price updated to: " + price);
        } else {
            System.out.println("Price should be positive!");
        }
    }

    public static void addTreatmentOfPatients(Scanner scanner, Hospital hospital) {
        System.out.print("Enter the room ID: ");
        int roomId = scanner.nextInt();
        Room room = hospital.searchRoomIdExist(roomId);
        if (room == null) {
            return;
        }
        Patient patient = room.getPatientInRoom();
        if (patient == null) {
            System.out.println("No patient is staying in room " + roomId);
            return;
        }
        try {
            System.out.print("Enter the treatment ID (1-5): ");
            int treatmentId = scanner.nextInt();
            patient.setTreatmentNo(treatmentId);
            System.out.println("Treatment added successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void dischargePatients(Scanner scanner, Hospital hospital) {
        System.out.print("Enter room ID: ");
        int roomId = scanner.nextInt();
        Room room = hospital.searchRoomIdExist(roomId);
        if (room == null) {
            return;
        }
        Patient patient = room.getPatientInRoom();
        if (patient == null) {
            System.out.println("No patient is staying in room " + roomId);
            return;
        }
        System.out.print("Enter no of days: ");
        int noOfDays = scanner.nextInt();
        if (noOfDays <= 0) {
            System.out.println("Number of days should be positive. Patient not discharged.");
            return;
        }
        double roomCharges = room.calculatePrice() * noOfDays;
        double docCharges = hospital.getDocCharges(patient.getDoctorId());
        double treatmentCharges = (patient.getTreatmentNo() == 0) ? 0 : hospital.getTreatmentCharges(patient.getTreatmentNo());
        double totalBill = roomCharges + docCharges + treatmentCharges;

        System.out.println("Bill Summary: ");
        System.out.println("-------------------------------------------");
        System.out.println("| Room Charges       |\t" + roomCharges + "\t|");
        System.out.println("| Doctor Charges     |\t" + docCharges + "\t|");
        if (treatmentCharges == 0) {
            System.out.println("| Treatment Charges  |\tNo treatment assigned\t|");
        } else {
            System.out.println("| Treatment Charges  |\t" + treatmentCharges + "\t|");
        }
        System.out.println("-------------------------------------------");
        System.out.println("| Total Bill         |\t" + totalBill + "\t|");

        hospital.setRoomAvailable(roomId);
    }

    public static void checkRoomAvailability(Scanner scanner, Hospital hospital) {
        System.out.print("Enter the room ID: ");
        int roomId = scanner.nextInt();
        Boolean isAvailable = hospital.checkRoomAvailable(roomId);
        if (isAvailable == null) {
        } else if (isAvailable == true) {
            System.out.println("Room is available");
        } else {
            System.out.println("Room is not available");
        }
    }

    public static void displayAllTheRooms(Hospital hospital) {
        hospital.displayRoomAvailability();
    }

}

