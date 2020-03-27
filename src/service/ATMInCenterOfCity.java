package service;

import atm.AccountHolder;
import atm.Bank;
import atm.BankTransaction;

public class ATMInCenterOfCity extends BankTransaction {

    public ATMInCenterOfCity(AccountHolder.Account account, Integer myPIN) {
        super(account, myPIN);
    }

    public static void main(String[] args) {
        MyBank.createAccounts();
        System.out.println("  Accounts in my Bank");
        System.out.println("-----------------------");
        System.out.println(Bank.getAllAccountUsersOfTheBank());
        System.out.println();
        //first user enters card to ATM
        BankTransaction bankTransactionOFFirstUser = new BankTransaction(MyBank.accountHolder1.getAccount(),
                1123);
        //see how much money you have
        System.out.println("Left: " + bankTransactionOFFirstUser.getCurrentAccount().getAmount() +
                "$ in card");
        //take money
        bankTransactionOFFirstUser.withdraw(100);
        //transfer money to another user
        bankTransactionOFFirstUser.transfer("7598714259803650", 3000);
        System.out.println(bankTransactionOFFirstUser.getCurrentAccount().getUserID() +
                " account holder's transaction history: ");
        bankTransactionOFFirstUser.seeTransactionHistory();
        bankTransactionOFFirstUser.quit();

        System.out.println("\n\n");
        //enter another card to ATM
        BankTransaction bankTransactionOfSecondUser = new BankTransaction(MyBank.accountHolder2.getAccount(),
                1212);
        //enter again (correctly)
        bankTransactionOfSecondUser = new BankTransaction(MyBank.accountHolder2.getAccount(), 4545);
        System.out.println("Left: " + bankTransactionOfSecondUser.getCurrentAccount().getAmount() +
                "$ in card");
        System.out.println(bankTransactionOfSecondUser.getCurrentAccount().getUserID() +
                " account holder's transaction history: ");
        bankTransactionOfSecondUser.seeTransactionHistory();
        //take money
        bankTransactionOfSecondUser.withdraw(150);
        System.out.println("Left: " + bankTransactionOfSecondUser.getCurrentAccount().getAmount() +
                "$ in card");
        System.out.println(bankTransactionOfSecondUser.getCurrentAccount().getUserID() +
                " account holder's transaction history: ");
        bankTransactionOfSecondUser.seeTransactionHistory();
        bankTransactionOfSecondUser.quit();
    }
}
