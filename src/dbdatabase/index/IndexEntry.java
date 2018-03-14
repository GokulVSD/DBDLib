package dbdatabase.index;

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

    public void addAccount(String accountNo){
        entry += accountNo + ":" + "open" + ":";
    }

    public void closeAccount(String accountNo){
        int accountIndex = entry.indexOf(accountNo);
        if(entry.contains(accountNo))
            entry = entry.substring(0,accountIndex) + entry.substring(accountIndex).replaceFirst("open","closed");
    }
    public void reopenAccount(String accountNo){
        int accountIndex = entry.indexOf(accountNo);
        entry = entry.substring(0,accountIndex) + entry.substring(accountIndex).replaceFirst("open","closed");
    }
    public void activateCustomer(){
        entry = entry.replaceFirst("deactivated","activated");
    }
    public void deactivateCustomer(){
        entry = entry.replaceFirst("activated","deactivated");
    }
    public void save(){
        super.writeCustomerEntry(customerID,entry);
        super.close();
    }

}
