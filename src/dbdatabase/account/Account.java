package dbdatabase.account;

import dbdatabase.customer.Customer;

public class Account extends Customer {

    protected String accountNo;
    protected String account;

    public Account(String accountNo) throws Exception { //gets customerID from index, and passes to super. calls super's getAccount//
        super(null);
        this.accountNo = accountNo;
    }

    String getAccountDetail(String key){return null;}
    void appendAccountLog(String log){}
    void save(){} //calls super's writeAccount, then calls super's close
    public void close(){} //calls super's close //not needed


}
