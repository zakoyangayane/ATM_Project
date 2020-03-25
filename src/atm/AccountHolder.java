package atm;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * AccountHolder class is used for the person who owns an account in the current bank.
 * He/She should have given his/her full name, birthday, passport numbers and his/her account
 * present in the bank.
 * When an Account Holder is created he/she is added to the list of users of the Bank.
 *
 * @author Zakoyan Gayane
 * @since 25.03.2020
 */
public class AccountHolder {
    private String firstName;
    private String lastName;
    private String birthday;
    private String passportNumbers;
    private Account account;

    public AccountHolder(String firstName, String lastName,
                         String birthday, String passportNumbers, Account account) {
        if (passportNumbers.length() != 10) {
            throw new IllegalArgumentException("Passport number is incorrect! Should have length of 10");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.passportNumbers = passportNumbers;
        this.account = account;
        Bank.getAllAccountUsersOfTheBank().add(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getPassportNumbers() {
        return passportNumbers;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", passportNumbers='" + passportNumbers.substring(0, 2) + "*******" + '\'' +
                ", account=" + account +
                '}';
    }

    /**
     * Account class is every user of the card of the current bank,
     * and the user has his/her ID, PIN and amount present in the card.
     * This is an inner class of AccountHolder, meaning it can't be made for
     * a user, without having created their Account Holder in Bank.
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

        private Map<Date, String> transactionHistory = new LinkedHashMap<>();

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

        public Map<Date, String> getTransactionHistory() {
            return transactionHistory;
        }

        @Override
        public String toString() {
            return "UserID: " + userID.substring(0, 3) + "********" + userID.substring(12, 15) +
                    "\nUserPIN: **** \nAmount: " + amount;
        }

    }
}
