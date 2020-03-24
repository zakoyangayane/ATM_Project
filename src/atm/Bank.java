package atm;

import java.util.ArrayList;
import java.util.List;

/**
 * Bank class is for creating a certain bank, with its name,
 * users, and ATMs.
 *
 * @author Zakoyan Gayane
 * @since 25.03.2020
 */
public class Bank {

    /**
     * name of the bank
     */
    public String name;

    /**
     * all users list of the bank
     */
    private List<Account> allAccountsOfBank = new ArrayList<>();

    public Bank(String name) {
        this.name = name;
    }

    public List<Account> getAllAccountsOfBank() {
        return allAccountsOfBank;
    }

}
