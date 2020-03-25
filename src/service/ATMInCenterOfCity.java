package service;

import atm.BankTransaction;

public class ATMInCenterOfCity extends BankTransaction {

    public ATMInCenterOfCity(String myID, int myPIN) {
        super(myID, myPIN);
    }

    public static void main(String[] args) {
        MyBank.createAccounts();

        //first user enters card to ATM
        BankTransaction bankTransactionOFFirstUser = new BankTransaction("1234564519806980",
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

        //enter another card to ATM
        BankTransaction bankTransactionOfSecondUser = new BankTransaction("5496846465416545646",
                1212);
        //enter again (correctly)
        bankTransactionOfSecondUser = new BankTransaction("7598714259803650", 4545);
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
