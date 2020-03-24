package atm;

/**
 * AccountHolder class is used for the person who owns an account in the current bank.
 * He/She should have given his/her full name, birthday and passport numbers
 *
 * @author Zakoyan Gayane
 * @since 25.03.2020
 */
public class AccountHolder {
    private String firstName;
    private String lastName;
    private String birthday;
    private String passportNumbers;

    public AccountHolder(String firstName, String lastName, String birthday, String passportNumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.passportNumbers = passportNumbers;
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


}
