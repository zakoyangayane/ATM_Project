package atm;

/**
 * Account class is every user of the card of the current bank,
 * and the user has his/her ID, PIN.
 *
 * @author Zakoyan Gayane
 * @since 24.03.2020
 */
public class Account {

    /**
     * ID of the user, which should have a length of 16
     */
    private String userID;

    /**
     * PIN of the user, which should contain 4 digits
     */
    private int userPIN;

    /**
     * money of the user present in his/her card
     */
    private int money;

    public Account(String userID, int userPIN) {
        if (userID.length() != 16) {
            throw new IllegalArgumentException("The user's ID should have a length of 16!");
        }
        if (userPIN > 9999 || userPIN < 1000) {
            throw new IllegalArgumentException("The user's PIN should contain 4 digits!");
        }
        this.userID = userID;
        this.userPIN = userPIN;
    }

    public String getUserID() {
        return userID;
    }

    public int getUserPIN() {
        return userPIN;
    }

    public int getMoney() {
        return money;
    }

}
