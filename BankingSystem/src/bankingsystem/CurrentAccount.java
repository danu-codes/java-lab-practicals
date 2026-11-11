package bankingsystem;

class CurrentAccount extends BankAccount {

    private double odLimit;

    public CurrentAccount(String accountNumber, String accountOwnerNic, double balance, double odLimit) {
        super(accountNumber, accountOwnerNic, balance);
        setOdLimit(odLimit);
        this.setAccountType("Current");
        this.setMinimumBalance(10000.00);
    }
    

    public void setOdLimit(double odLimit) {
        if (odLimit > 0) {
            this.odLimit = odLimit;
        } else {
            System.out.println("odLimit should be Positive!");
        }
    }

    public double getOdLimit() {
        return odLimit;
    }
    
    @Override
    public void withdraw(double amount)
    {
        if( amount<=0)
        {
            System.out.println("withdraw or odLimit should be Positive!");
        }
        else if( (getBalance() - amount)< -odLimit )
        {
            System.out.println("withdraw amount exceeds odLimit!");
        }
        else
        {
            setBalance( getBalance() - amount );
            System.out.println("Amount withdrawed to Account number : " + getAccountNumber() + "!");
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nodLimit            : " + odLimit;
    }

}
