package dbdatabase.account;

import dbdatabase.customer.Customer;
import dbdatabase.index.Index;
import dbdatabase.index.IndexCreator;

public class AccountCreator extends Customer {

    protected String account;
    protected String accountNo;

    public AccountCreator(String customerID){

        super(customerID);
    }

    CustomerEditor(String customerID,String accountNo)throws Exception; //calls initStructure
    void initStructure();
    void setBalance(String balance);
	.
            . //method for every field
    void setAccountType(String type);
    void save(); //Adds entry into IndexEntry with account status, then calls super's writeAccount, then calls super's close


}
