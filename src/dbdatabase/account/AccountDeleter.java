package dbdatabase.account;

import dbdatabase.index.IndexEntry;

//this class hasn't been tested
public class AccountDeleter extends Account{

    public AccountDeleter(String accountNo)throws Exception {

        super(accountNo);
        try {
            IndexEntry iE = new IndexEntry(super.customerID);
            iE.closeAccount(super.accountNo);
            iE.close();
        } catch (Exception e){
            super.save();
            throw new Exception("DBDatabase: Can't delete, Index file currently being used");
        }
        delete();
    }

    private void delete(){
        super.account = null;
        super.save();
    }
}
