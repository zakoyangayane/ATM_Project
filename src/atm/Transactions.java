package atm;

/**
 * functions that an ordinary ATM should have by implementing this interface
 *
 * @author Zakoyan Gayane
 * @since 25.03.2020
 */
public interface Transactions {

    /**
     * when card entered to the ATM and recognized it, then it must show what actions
     * can be done by that ATM
     */
    void showActions();

    /**
     * transactions history of a current user
     *
     * @return the day done the transaction and the action description
     */
    void seeTransactionHistory();

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
     * @param accountIDToWhichTransferring the ID of the account holder
     * @param amountToTransfer             size of transferring money
     * @return true if the action has been completed successfully
     */
    boolean transfer(String accountIDToWhichTransferring, int amountToTransfer);

    /**
     * for closing the account from the ATM, it's needed to quit it
     *
     * @return true if quited successfully
     */
    boolean quit();
}
