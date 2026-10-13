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
}