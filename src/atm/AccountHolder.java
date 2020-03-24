package atm;

import java.util.ArrayList;
import java.util.List;

public class AccountHolder {

    /**
     * list that contains all the accounts that are registered in the current bank
     */
    private List<Account> allAccountsOfBank = new ArrayList<>();

    public List<Account> getAllAccountsOfBank() {
        return allAccountsOfBank;
    }
}
