public abstract class BankAccount {
    protected String accountName;
    protected double amount;

    public BankAccount(String accountName){
        this.accountName = accountName;
        amount = 0.0;
    }

    public void deposit(double newAmount){
        if (newAmount <= 0.0){
            throw new IllegalArgumentException("Amount must be greater that 0.0");
        }
        amount += newAmount;
    }

    public void withdraw(double withdraw){
        if (withdraw <= 0.0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than 0");
        }

        if (withdraw > amount) {
            throw new IllegalArgumentException("Insufficient funds!");
        }
        amount -= withdraw;
    }

    public String getAccountName(){return this.accountName;}

    public double getBalance(){return amount;}
}