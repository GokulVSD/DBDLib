package dbdatabase.account;

public class AccountEditor extends Account {

    public AccountEditor(String accountNo)throws Exception {

        super(accountNo);
    }
    void editAccountDetail(String key,String value){}
    void appendAccountLog(String log){} //calls super's appendAccountLog //not needed
    void save(){} //calls super's save //not needed


}
