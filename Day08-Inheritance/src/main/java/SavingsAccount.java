public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(String accountName, double interestRate){
        super(accountName);
        this.interestRate = interestRate;
    }

    public void applyInterest(){
        double newAmount = this.amount * this.interestRate;
        this.amount += newAmount;
    }

    public String getAccountNumber(){return this.accountName;}

    @Override
    public void withdraw(double withdraw){
        if (withdraw <= 0.0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        }

        if (this.amount - withdraw < 100.0){
            throw new IllegalArgumentException("Error: Funds must be higher than R100 after withdrawal");
        }
        this.amount -= withdraw;
    }
}