package atm;

/**
 * Account class is every user of the card of the current bank,
 * and the user has his/her ID, PIN and amount present in the card.
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
    private int amount;

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "UserID: " + userID.substring(0, 3) + "********" + userID.substring(12, 15) +
                "\nUserPIN: **** \nAmount: " + amount;
    }

}
