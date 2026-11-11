package bankingsystem;

class Rankekulu extends SavingAccount {

    private String guardianName;
    private int age;

    public Rankekulu(String accountNumber, String accountOwnerNic, String guardianName, double balance, int age) {
        super(accountNumber, accountOwnerNic, balance);
        setGuardianName(guardianName);
        setAge(age);
        this.setAccountType("Rankekulu");
        this.setAccountOwnerNic(accountOwnerNic);
        this.setInterestRate(12);
        this.setMinimumBalance(500.00);
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public void setAge(int age) {
        if (age > 0 && age < 18) {
            this.age = age;
        } else {
            System.out.println("Age should be less than 18 & positive!");
        }
    }

    public String getGuardianName() {
        return guardianName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nguardianName       : " + guardianName +
               "\nage                : " + age;
    }
    
    

}
