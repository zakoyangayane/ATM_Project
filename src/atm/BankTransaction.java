package atm;

/**
 * Bank transaction class is used for the actions that the user can do with his/her account.
 * They can see their history of the account, take amount from the card,
 * transfer some money to another user or quit the account from the ATM.
 *
 * @author Zakoyan Gayane
 * @since 25.03.2020
 */
public class BankTransaction {

    /**
     * account which has been entered to the ATM
     */
    private Account currentAccount;

    public BankTransaction(Account account) {
        this.currentAccount = account;
    }

    /**
     * for the user to see his/her transaction history done with the ATM
     */
    public void seeTransactionHistory() {
        
    }

    /**
     * to take an amount of money from his card through the ATM
     *
     * @param amountToTake he wants to take
     * @return amount he has taken
     */
    public int withdraw(int amountToTake) {
        if (amountToTake > currentAccount.getAmount()) {
            throw new IllegalArgumentException("Not enough amount in your account!");
        } else {
            currentAccount.setAmount(currentAccount.getAmount() - amountToTake);
            return amountToTake;
        }
    }

    /**
     * for transferring a certain amount to another user's account,
     * after transferring it is required that in the card should remain at least 500$
     *
     * @param accountToWhichTransferring to whom he is going to transfer
     * @param amountToTransfer           of money he is going to transfer
     * @return true if the transaction has been completed successfully,
     * false otherwise.
     */
    public boolean transfer(Account accountToWhichTransferring, int amountToTransfer) {
        if (currentAccount.getAmount() - 500 < amountToTransfer) {
            throw new IllegalArgumentException("after transferring it is required in the" +
                    " card to remain at least 500$");
        } else {

            //removing the amount from the current account
            currentAccount.setAmount(currentAccount.getAmount() - amountToTransfer);

            //adding the amount which is being transferred to another user
            accountToWhichTransferring.setAmount(accountToWhichTransferring.getAmount() + amountToTransfer);
            return true;
        }
    }

    /**
     * for closing the ATM from the account, it's needed just to press quit
     *
     * @return true when the current account has been successfully closed from the ATM
     */
    public boolean quit() {
        currentAccount = null;
        return true;
    }

}
