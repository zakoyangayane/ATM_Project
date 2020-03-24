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
     * number of the ATMs that has the bank
     */
    public int numberOfATMs;

    /**
     * all users list of the bank
     */
    private static List<AccountHolder> allAccountUsersOfTheBank = new ArrayList<>();

    public Bank(String name, int numberOfATMs) {
        this.name = name;
        this.numberOfATMs = numberOfATMs;
    }

    public static List<AccountHolder> getAllAccountUsersOfTheBank() {
        return allAccountUsersOfTheBank;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", numberOfATMs=" + numberOfATMs +
                '}';
    }
}
