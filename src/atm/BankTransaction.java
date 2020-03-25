package atm;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Bank transaction class is used for the actions that the user can do with his/her account.
 * This class implements the Transactions interface to have the necessary functions.
 * The users can see their history of the account, take amount from the card,
 * transfer some money to another user or quit the account from the ATM.
 *
 * @author Zakoyan Gayane
 * @since 25.03.2020
 */
public class BankTransaction implements Transactions {

    /**
     * account which has been entered to the ATM
     */
    private AccountHolder.Account currentAccount;

    public BankTransaction(String myID, Integer myPIN) {
        for (int i = 0; i < Bank.getAllAccountUsersOfTheBank().size(); i++) {
            AccountHolder.Account curAccount = Bank.getAllAccountUsersOfTheBank().get(i).getAccount();
            if (curAccount.getUserID().equals(myID)
                    && curAccount.getUserPIN().equals(myPIN)) {
                this.currentAccount = curAccount;
                System.out.println("Card entered successfully! " + '\u263A');
                showActions();
                break;
            } else if (i == Bank.getAllAccountUsersOfTheBank().size() - 1 && (!curAccount.equals(currentAccount))) {
                System.out.println("Not correct User ID or PIN");
                quit();
            }
        }
    }

    public AccountHolder.Account getCurrentAccount() {
        return currentAccount;
    }

    /**
     * when the user has entered valid ID and PIN, he can already see and
     * choose what action he wants to complete
     */
    @Override
    public void showActions() {
        System.out.println("\n-----Choose the action-----");
        System.out.println("*  See Transaction History");
        System.out.println("*  Withdraw");
        System.out.println("*  Transfer");
        System.out.println("*  Quit\n");
    }

    /**
     * for the user to see his/her transaction history done with the ATM
     */
    @Override
    public void seeTransactionHistory() {
        if (currentAccount.getTransactionHistory().isEmpty()) {
            System.out.println("No history");
        }
        Iterator<Map.Entry<Date, String>> iterator = currentAccount.getTransactionHistory().entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Date, String> me2 = (Map.Entry<Date, String>) iterator.next();
            System.out.println("On " + me2.getKey() + " - " + me2.getValue());
        }
    }

    /**
     * to take an amount of money from his card through the ATM
     *
     * @param amountToTake he wants to take
     * @return amount he has taken
     */
    @Override
    public int withdraw(int amountToTake) {
        Date date = new Date();
        if (amountToTake > currentAccount.getAmount()) {
            throw new IllegalArgumentException("Not enough amount in your account!");
        } else {
            currentAccount.setAmount(currentAccount.getAmount() - amountToTake);
            currentAccount.getTransactionHistory().put(date, "Taken " + amountToTake + "$");
            return amountToTake;
        }
    }

    /**
     * for transferring a certain amount to another user's account,
     * after transferring it is required that in the card should remain at least 500$
     *
     * @param accountIDToWhichTransferring to whom he is going to transfer
     * @param amountToTransfer             of money he is going to transfer
     * @return true if the transaction has been completed successfully,
     * false if the userID not found in the bank.
     */
    @Override
    public boolean transfer(String accountIDToWhichTransferring, int amountToTransfer) {
        Date date = new Date();
        if (currentAccount.getAmount() - 500 < amountToTransfer) {
            throw new IllegalArgumentException("after transferring, it is required in the" +
                    " card to remain at least 500$");
        } else {
            AccountHolder.Account accountToTransfer = null;
            for (int i = 0; i < Bank.getAllAccountUsersOfTheBank().size(); i++) {
                accountToTransfer = Bank.getAllAccountUsersOfTheBank().get(i).getAccount();
                if (accountToTransfer.getUserID().equals(accountIDToWhichTransferring)) {

                    //removing the amount from the current account
                    currentAccount.setAmount(currentAccount.getAmount() - amountToTransfer);

                    //adding the amount which is being transferred to another user
                    accountToTransfer.setAmount(accountToTransfer.getAmount() + amountToTransfer);

                    currentAccount.getTransactionHistory().put(date, "Transferred " + amountToTransfer +
                            "$ to " + accountToTransfer.getUserID());
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * for closing the ATM from the account, it's needed just to press quit
     *
     * @return true when the current account has been successfully closed from the ATM
     */
    @Override
    public boolean quit() {
        currentAccount = null;
        System.out.println("Card is exited from the ATM. Thanks for using the service " + '\u263A');
        return true;
    }

}
