package atm;

import java.util.Date;
import java.util.Map;

/**
 * functions that an ordinary ATM should have by implementing this interface
 *
 * @author Zakoyan Gayane
 * @since 25.03.2020
 */
public interface Transactions {
    Map<Date, String> seeTransactionHistory();

    int withdraw(int amountToTake);

    boolean transfer(Account accountToWhichTransferring, int amountToTransfer);

    boolean quit();
}
