package atm;

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
}
