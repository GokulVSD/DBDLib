package dbdatabase.account;

public class AccountDeleter extends Account{

    AccountDeleter(String accountNo)throws Exception {

        super(accountNo);
    }
    void delete(){} //sets super's account variable to null, Sets account status to closed in the IndexEntry
    void save(){} //calls super's save //not needed
}
