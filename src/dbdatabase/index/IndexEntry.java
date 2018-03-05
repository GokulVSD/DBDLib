package dbdatabase.index;

public class IndexEntry extends Index {

    protected String entry;
    protected String customerID;

    public IndexEntry(String customerID)throws Exception{
        super();
    } //calls super's constructor, then calls super's getCustomerEntry. if it returns null, then {calls super's writeCustomerEntry,
    // then calls super's close}

    void addAccount(String accountNo){} //adds account to entry, and sets its status to open
    void closeAccount(String accountNo){}
    void reopenAccount(String accountNo){}
    void activateCustomer(){}
    void deactivateCustomer(){}
    void save(){} //calls super's writeCustomerEntry, then calls super's close

}
