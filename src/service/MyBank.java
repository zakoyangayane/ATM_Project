package service;

import atm.AccountHolder;
import atm.Bank;

public class MyBank {

    //creating a bank
    Bank myBank = new Bank("Armenia Bank", 15);

    //create users
    static AccountHolder accountHolder1;
    static AccountHolder accountHolder2;

    public static void createAccounts() {
        //define a user
        accountHolder1 = new AccountHolder("Gayane", "Zakoyan", "03.05.2000",
                "123456AAA", null);

        //create and attach account to the account holder
        accountHolder1.setAccount(accountHolder1.new Account("1234564519806980", 1123));

        //set amount in the card of the user
        accountHolder1.getAccount().setAmount(10000);


        //define one more user
        accountHolder2 = new AccountHolder("Mane", "Zakoyan", "18.09.2006",
                "789456JJJ", null);

        //create and attach account to the second accont holder
        accountHolder2.setAccount(accountHolder2.new Account("7598714259803650", 4545));

        //set amount for second user
        accountHolder2.getAccount().setAmount(5000);

    }

}
