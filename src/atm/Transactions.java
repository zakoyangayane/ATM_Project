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

    /**
     * transactions history of a current user
     *
     * @return the day done the transaction and the action description
     */
    Map<Date, String> seeTransactionHistory();

    /**
     * action for taking money on cash from card
     *
     * @param amountToTake defining the size of amount
     * @return the cash from card
     */
    int withdraw(int amountToTake);

    /**
     * an action for transferring an amount of money to other user
     *
     * @param accountToWhichTransferring the ID of the account holder
     * @param amountToTransfer           size of transferring money
     * @return true if the action has been completed successfully
     */
    boolean transfer(Account accountToWhichTransferring, int amountToTransfer);

    /**
     * for closing the account from the ATM, it's needed to quit it
     *
     * @return true if quited successfully
     */
    boolean quit();
}
