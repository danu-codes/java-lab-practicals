package bankingsystem;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class BankingSystem {

    private static Scanner input = new Scanner(System.in);
    private final static int MAX_ACCOUNT_COUNT = 100;
    private static int accountCount = 0;
    private static BankAccount[] accounts = new BankAccount[MAX_ACCOUNT_COUNT];

    public static void main(String[] args) {

        printMainMenu();

    }

    public static void printMainMenu() {

        int choice;

        do {
            System.out.println("\nMain Menu");
            System.out.println("=========");
            System.out.println("(1) Deposit");
            System.out.println("(2) Withdraw");
            System.out.println("(3) Check Balance");
            System.out.println("(4) Add an Account");
            System.out.println("(5) Print Account Details");
            System.out.println("(6) Save Gift List");
            System.out.println("(7) Exit");

            System.out.print("Enter your choice [1-7] : ");
            choice = input.nextInt();

            input.nextLine();

            switch (choice) {
                case 1:
                    deposit(accounts, accountCount);
                    break;

                case 2:
                    withdraw(accounts, accountCount);
                    break;

                case 3:
                    checkBalance(accounts, accountCount);
                    break;

                case 4:
                    addAccount();
                    break;

                case 5:
                    printAccountDetails(accounts, accountCount);
                    break;

                case 6:
                    saveGiftList(accounts, accountCount);
                    break;

                case 7:
                    System.out.println("Program Terminated !");
                    break;

                default:
                    System.out.println("\nInvalid choice !");
                    System.out.println("Choose your choice between 1-7 !");
                    break;
            }

        } while (choice != 7);
    }

    public static BankAccount addAccount() {

        BankAccount newAccount = null;

        if (accountCount < MAX_ACCOUNT_COUNT) {

            System.out.println("\n=== Add Account ===");

            System.out.print("Enter account type : ");
            String acc_type = input.nextLine();

            System.out.print("Enter account number : ");
            String acc_no = input.nextLine();

            for (int i = 0; i < accountCount; i++) {
                if (accounts[i].getAccountNumber().equals(acc_no)) {
                    System.out.println("Account number already exists!");
                    return null;
                }
            }

            System.out.print("Enter initial Deposit : ");
            double initialDeposit = input.nextDouble();

            input.nextLine();

            if (initialDeposit < 0) {
                System.out.println("Initial deposit should be Positive!");
                return null;
            }

            if (acc_type.equalsIgnoreCase("Rankekulu")) {
                System.out.print("Enter guardian NIC : ");
                String guardian_nic = input.nextLine();

                System.out.print("Enter guardian name : ");
                String guardian_name = input.nextLine();

                System.out.print("Enter age of the child : ");
                int child_age = input.nextInt();

                input.nextLine();

                if (child_age <= 0 || child_age >= 18) {
                    System.out.println("Age should be less than 18 & positive!");
                    return null;
                }

                newAccount = new Rankekulu(acc_no, guardian_nic, guardian_name, initialDeposit, child_age);
            } else if (acc_type.equalsIgnoreCase("Current")) {
                System.out.print("Enter owner NIC : ");
                String owner_nic = input.nextLine();

                System.out.print("Enter overdraft limit : ");
                double odLimit = input.nextDouble();
                input.nextLine();
                newAccount = new CurrentAccount(acc_no, owner_nic, initialDeposit, odLimit);
            } else if (acc_type.equalsIgnoreCase("Saving")) {

                System.out.print("Enter owner NIC : ");
                String owner_nic = input.nextLine();

                newAccount = new SavingAccount(acc_no, owner_nic, initialDeposit);

            } else {
                System.out.println("Invalid account type!");
                return null;
            }

            if (newAccount != null) {
                accounts[accountCount] = newAccount;
                accountCount++;
                System.out.println("Account Successfully Created !");
            }
        } else {
            System.out.println("Maximum number of accounts is reached!");
        }
        return newAccount;

    }

    public static int findIndexOfAccount(BankAccount[] accounts, int accountCount) {
        System.out.print("Enter an account number : ");
        String acc_no = input.nextLine();

        for (int index = 0; index < accountCount; index++) {
            if (accounts[index].getAccountNumber().equals(acc_no)) {
                return index;
            }

        }
        System.out.println("Account number not found!");
        return -1;

    }

    public static void deposit(BankAccount[] accounts, int accountCount) {
        int index = findIndexOfAccount(accounts, accountCount);

        if (index != -1) {
            System.out.print("Enter deposit amount : ");
            double depositAmount = input.nextDouble();

            input.nextLine();

            double balanceBefore = accounts[index].getBalance();
            accounts[index].deposit(depositAmount);
            if (accounts[index].getBalance() > balanceBefore) {
                System.out.println("Amount deposited to Account number : " + accounts[index].getAccountNumber() + "!");
            }
        }
    }

    public static void withdraw(BankAccount[] accounts, int accountCount) {
        int index = findIndexOfAccount(accounts, accountCount);

        if (index != -1) {
            System.out.print("Enter withdraw amount : ");
            double withdrawAmount = input.nextDouble();
            input.nextLine();
            accounts[index].withdraw(withdrawAmount);
        }

    }

    public static void checkBalance(BankAccount[] accounts, int accountCount) {
        int index = findIndexOfAccount(accounts, accountCount);

        if (index != -1) {
            System.out.println("Account Number  : " + accounts[index].getAccountNumber());
            System.out.println("Account Balance : " + accounts[index].getBalance());
        }
    }

    public static void printAccountDetails(BankAccount[] accounts, int accountCount) {

        if (accountCount != 0) {
            System.out.println("\n|Acc No      |Type      |Owner NIC      |Balance");
            System.out.println("==================================================");

            for (int index = 0; index < accountCount; index++) {
                BankAccount acc = accounts[index];
                //System.out.println( accounts[index].getAccountNumber()      +accounts[index].getAccountType()+      accounts[index].getAccountOwnerNic()+      accounts[index].getBalance());
                System.out.printf(" %-11s  %-9s  %-13s  %10.2f  \n", acc.getAccountNumber(), acc.getAccountType(), acc.getAccountOwnerNic(), acc.getBalance());
            }
        } else {
            System.out.println("\nNo Account Details!");
            System.out.println("Add Account Details!");
        }
    }

    public static String checkGiftEligible(int age, double balance) {
        if (age <= 5 && balance >= 5000) {
            return "Soft Toy";
        } else if ((age > 5 && age <= 10) && balance >= 10000) {
            return "School Bag";
        } else if ((age > 10 && age <= 15) && balance >= 15000) {
            return "Musical Instrument";
        } else if ((age > 15 && age < 18) && balance >= 25000) {
            return "Sport Bike";
        } else {
            return "No Gift";
        }
    }

    public static void saveGiftList(BankAccount[] accounts, int accountCount) {
        try (FileWriter writer = new FileWriter("gift_List.txt")) {
            boolean hasRankekulu = false;
            for (int index = 0; index < accountCount; index++) {
                BankAccount acc = accounts[index];

                if (acc.getAccountType().equalsIgnoreCase("Rankekulu")) {
                    hasRankekulu = true;
                    Rankekulu rankekulu = (Rankekulu) accounts[index];
                    String gift = checkGiftEligible(rankekulu.getAge(), rankekulu.getBalance());

                    writer.write(
                            "\n" + rankekulu.getAccountNumber() + ", "
                            + rankekulu.getAge() + ", "
                            + rankekulu.getAccountOwnerNic() + ", "
                            + rankekulu.getBalance() + ", "
                            + gift);
                }
            }

            if (!hasRankekulu) {
                System.out.println("No Rankekulu accounts available for gifts!");
            } else {
                System.out.println("Gift list saved to gift_List.txt");
            }
        } catch (IOException e) {
            System.out.println("Error saving gift list : " + e.getMessage());
        }
    }

}
