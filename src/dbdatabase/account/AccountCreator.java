package dbdatabase.account;

import dbdatabase.customer.Customer;
import dbdatabase.index.Index;
import dbdatabase.index.IndexCreator;
import dbdatabase.index.IndexEntry;

//this class has not been tested
public class AccountCreator extends Customer {

    private String account;
    private String accountNo;

    public AccountCreator(String customerID,String accountNo)throws Exception {
        super(customerID);
        try{
            IndexEntry iE = new IndexEntry(customerID);
            iE.addAccount(accountNo);
            iE.save();
        } catch (Exception e){
            super.close();
            throw new Exception("DBDatabase: Can't create new account since Index file is currently being used");
        }
        this.accountNo = accountNo;
        initStructure();
    }

    private void initStructure(){
        account = "," + "!" + "," + "!";
    }

    void save(){
        super.writeAccount(accountNo,account);
        super.close();
    }
}
