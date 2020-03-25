package service;

import atm.BankTransaction;

public class ATMInCenterOfCity extends BankTransaction {

    public ATMInCenterOfCity(String myID, int myPIN) {
        super(myID, myPIN);
    }

    public static void main(String[] args) {
        MyBank.createAccounts();


    }
}
