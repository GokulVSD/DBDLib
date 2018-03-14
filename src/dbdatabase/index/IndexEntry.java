package dbdatabase.index;

import java.util.StringTokenizer;

//this class has not been tested
public class IndexEntry extends Index {

    private String entry;
    private String customerID;

    public IndexEntry(String customerID)throws Exception{
        super();
        this.customerID = customerID;
        entry = super.getCustomerEntry(customerID);
        if(entry == null){
            entry = customerID + ":" + "activated" + ":";
            save();
        }
    }

    void addAccount(String accountNo){
        entry += accountNo + ":" + "open" + ":";
    }

    void closeAccount(String accountNo){
        int accountIndex = entry.indexOf(accountNo);
        if(entry.contains(accountNo))
            entry = entry.substring(0,accountIndex) + entry.substring(accountIndex).replaceFirst("open","closed");
    }
    void reopenAccount(String accountNo){
        int accountIndex = entry.indexOf(accountNo);
        entry = entry.substring(0,accountIndex) + entry.substring(accountIndex).replaceFirst("open","closed");
    }
    void activateCustomer(){
        entry = entry.replaceFirst("deactivated","activated");
    }
    void deactivateCustomer(){
        entry = entry.replaceFirst("activated","deactivated");
    }
    void save(){
        super.writeCustomerEntry(customerID,entry);
        super.close();
    }

}
