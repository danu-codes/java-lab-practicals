package payablesystem;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class PayableSystem {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Payable> payableObj = new ArrayList<Payable>();

    public static void main(String[] args) {
        printMenu();
    }

    public static void printMenu() {
        int choice;

        do {
            System.out.println("\n  Welcome to StarX company");
            System.out.println("----------------------------------------");
            System.out.println("1. Register New Payable (Employee/Invoice)");
            System.out.println("2. Payable Recored");
            System.out.println("3. Print Payable");
            System.out.println("4. Exit");
            System.out.println("----------------------------------------\n");

            System.out.println("Enter your choice : ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    try {
                        registerNewPayable();
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nError : " + e.getMessage());
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("\nError : Invalid input type!");
                        input.nextLine();
                    }
                    break;
                case 2:
                    detailPayable();
                    break;
                case 3:
                    printPayable();
                    break;
                case 4:
                    System.out.println("\n---------------------------------------------");
                    System.out.println("Thank you for using StarX payable system. !!!");
                    System.out.println("---------------------------------------------\n");
                    break;
                default:
                    System.out.println("Invalid choice choose between [1-4] !");
                    break;
            }
        } while (choice != 4);

    }

    public static void registerNewPayable() {

        int choice;

        System.out.println("\n  Welcome to registration");
        System.out.println("----------------------------------------");
        System.out.println("Enter a relevant payable type : ");
        System.out.println("1. Invoice");
        System.out.println("2. Hourly employee");
        System.out.println("3. Commision employee");
        System.out.println("4. Base-salaried commision employee\n");

        System.out.println("Choose a payable : ");
        choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                System.out.println("\nInvoice : ");
                System.out.println("Enter part number : ");
                String partNumber = input.nextLine();

                System.out.println("Enter quantity : ");
                int quantity = input.nextInt();

                input.nextLine();

                System.out.println("Enter Price per item : ");
                double pricePerItem = input.nextDouble();

                payableObj.add(new Invoice(partNumber, quantity, pricePerItem));
                System.out.println("\nPayable is registered successfully!!\n");

                break;
            case 2:
                try{
                System.out.println("\nHourly employee : ");
                System.out.println("Enter first name : ");
                String hfName = input.nextLine();

                System.out.println("Enter last name : ");
                String hlName = input.nextLine();

                System.out.println("Enter age : ");
                int hAge = input.nextInt();

                input.nextLine();

                System.out.println("Enter national identification number : ");
                String hNIC = input.nextLine();

                System.out.println("Enter wage per hours (Rs) : ");
                double wage = input.nextDouble();

                System.out.println("Enter number of hour : ");
                double hNumberOfHours = input.nextDouble();

                payableObj.add(new HourlyEmployee(hfName, hlName, hAge, hNIC, wage, hNumberOfHours));
                System.out.println("\nPayable is registered successfully!!\n");
                }
                catch(IllegalArgumentException e)
                {
                    System.out.println("\nError : "+e.getMessage());
                }
                break;

            case 3:
                System.out.println("\nCommission employee : ");
                System.out.println("Enter first name : ");
                String cfName = input.nextLine();

                System.out.println("Enter last name : ");
                String clName = input.nextLine();

                System.out.println("Enter age : ");
                int cAge = input.nextInt();

                input.nextLine();

                System.out.println("Enter national identification number : ");
                String cNIC = input.nextLine();

                System.out.println("Enter gross sale (Rs) : ");
                double grossSale = input.nextDouble();

                System.out.println("Enter commision rate : ");
                double CcommissionRate = input.nextDouble();

                payableObj.add(new CommissionEmplyee(cfName, clName, cAge, cNIC, grossSale, CcommissionRate));
                System.out.println("\nPayable is registered successfully!!\n");
                break;

            case 4:
                System.out.println("\nBase-salaried commission employee : ");
                System.out.println("Enter first name : ");
                String bscfName = input.nextLine();

                System.out.println("Enter last name : ");
                String bsclName = input.nextLine();

                System.out.println("Enter age : ");
                int bscAge = input.nextInt();

                input.nextLine();

                System.out.println("Enter national identification number : ");
                String bscNIC = input.nextLine();

                System.out.println("Enter gross sale (Rs) : ");
                double bscgrossSale = input.nextDouble();

                System.out.println("Enter commision rate : ");
                double bccommissionRate = input.nextDouble();

                System.out.println("Enter Base Salary : ");
                double bccBaseSalary = input.nextDouble();

                payableObj.add(new BasePlusCommisionEmployee(bscfName, bsclName, bscAge, bscNIC, bscgrossSale, bccommissionRate, bccBaseSalary));
                System.out.println("\nPayable is registered successfully!!\n");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
        return;

    }

    public static void detailPayable() {

        if (payableObj.isEmpty()) {
            System.out.println("No payable records found!");
            return;
        }

        System.out.println("\n=========Payable Records=========");
        for (Payable payable : payableObj) {
            System.out.println(payable.toString());
            System.out.println("\n");
        }
    }

    public static void printPayable() {

        if (payableObj.isEmpty()) {
            System.out.println("No payable records found!");
            return;
        }

        try (FileWriter writer = new FileWriter("AS2023908.txt")) {
            for (Payable payable : payableObj) {
                writer.write("\n" + payable.toString());
            }
            System.out.println("All records are recorded in the file successfully!");
        } catch (IOException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
