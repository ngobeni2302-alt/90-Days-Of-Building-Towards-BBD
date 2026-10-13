import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank(){this.accounts = new ArrayList<>();}

    public void addAccount(BankAccount account){
        if (account == null){
            throw new IllegalArgumentException("Error: Account is invalid");
        }
        this.accounts.add(account);
    }

    public double getTotalBalance(){
        double total = 0;
        for (BankAccount acc : this.accounts){
            double a = acc.getBalance();
            total += a;
        }
        return total;
    }

    public void applyInterestToAll(){
        for (BankAccount acc : this.accounts){
            if (acc instanceof SavingsAccount){
                SavingsAccount ac1 = (SavingsAccount) acc;

                ac1.applyInterest();
            }
        }
    }

    public BankAccount findAccount(String accountNumber){
        for (BankAccount acc : this.accounts){
            if (acc.getAccountName().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public List<BankAccount> getAccounts() {
        return new ArrayList<>(this.accounts);
    }
}