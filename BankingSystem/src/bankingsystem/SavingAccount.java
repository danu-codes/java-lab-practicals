package bankingsystem;

public class SavingAccount extends BankAccount {

    private double interestRate;

    public SavingAccount(String accountNumber, String accountOwnerNic, double balance) {
        super(accountNumber, accountOwnerNic, balance);
        this.setInterestRate(10);
        this.setAccountType("Saving");
        this.setMinimumBalance(1000.00);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        if (interestRate > 0) {
            this.interestRate = interestRate;
        } else {
            System.out.println("Interest Rate should be Positive!");
        }
    }
    
    @Override
    public void withdraw(double withdrawAmount)
    {
        if( withdrawAmount<=0 )
        {
            System.out.println("withdraw should be Positive!");
        }
        else if( getBalance() - withdrawAmount<getMinimumBalance() )
        {
            System.out.println("Withdraw Amount would go below minimum balance!");
        }
        else
        {
            setBalance( getBalance() - withdrawAmount );
            System.out.println("Amount withdrawed to Account number : " + getAccountNumber() + "!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\ninterestRate       : " + interestRate + "%";
    }
    
    

}
