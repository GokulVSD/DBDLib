package dbdatabase.account;

import dbdatabase.customer.Customer;

/**
 * Account no.
 * Retrieve from Customer Class Account info(Account no.)
 * Write to Customer Class Account info(key)
 */
public class Account extends Customer {

    protected String accountNo;
    protected String account;

    public Account(String accountNo) throws Exception //gets customerID from index, and passes to super. calls super's getAccount//
    {

        this.accountNo = accountNo;
    }

    String getAccountDetail(String key);
    void appendAccountLog(String log);
    void save(); //calls super's writeAccount, then calls super's close
    void close(); //calls super's close


}
//RANDOM CHANGES!