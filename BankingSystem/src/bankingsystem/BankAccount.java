package bankingsystem;

abstract class BankAccount implements IAccount {

    private String accountNumber;
    private String accountType;
    private String accountOwnerNic;
    private double balance;
    private double minimumBalance;

    public BankAccount(String accountNumber, String accountOwnerNic, double balance) {
        setAccountNumber(accountNumber);
        setAccountOwnerNic(accountOwnerNic);
        setBalance(balance);
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setMinimumBalance(double minimumBalance) {
        if (minimumBalance > 0) {
            this.minimumBalance = minimumBalance;
        } else {
            System.out.println("Minimum Balance should be Positive!");
        }
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountOwnerNic() {
        return accountOwnerNic;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountOwnerNic(String accountOwnerNic) {
        this.accountOwnerNic = accountOwnerNic;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void deposit(double amount) {
         if (amount>0)
         {
             balance += amount;
         }
         else
         {
             System.out.println("Deposit Amount should be Positive!");
         }
    }


    @Override
    public String toString() {
        return  
        "\nAccount Number      : " + accountNumber + 
        ",\nAccount Type       : " + accountType + 
        ",\nAccount Owner Nic  :  " + accountOwnerNic + 
        ",\nBalance            : " + balance +
        ",\nminimumBalance     : " + minimumBalance 
        ;
    }
    
    
}
