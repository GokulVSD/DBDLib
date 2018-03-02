package dbdatabase.account;

import dbdatabase.customer.Customer;

/**
 * Account no.
 * Retrieve from Customer Class Account info(Account no.)
 * Write to Customer Class Account info(key)
 */
public class Account extends Customer {

    protected String accountID;

    public Account(String accountID){

        this.accountID = accountID;
    }
}
