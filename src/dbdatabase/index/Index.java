package dbdatabase.index;

/**
 * Read Index File -> have a null pointer if it doesn't exist
 * Return accounts belonging to Customer ID
 * Write to Index File
 */
public class Index {

    public Index(){

    }
    LinkedList<String> entries;
    Index()throws Exception; //interfaces with DB class, throws exception if index file is already open. calls readEntries
    void readEntries();
    boolean isAccountOpen(String accountNo);
    boolean isCustomerDeactivated(String customerID);
    String[] getListOfAccounts(String customerID); //returns a String array of account numbers for a particular customerID
    String getCustomerEntry(String customerID); //returns null if does not exist
    void writeCustomerEntry(String customerID,String entry); //if customerID doesn not exist in entries, adds new node to LinkedList. if exists, replaces.
    void close(); //calls writeEntries
    void writeEntries();
}
