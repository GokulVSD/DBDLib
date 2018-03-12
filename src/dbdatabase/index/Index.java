package dbdatabase.index;

import dbdatabase.FileCreator;

import java.util.LinkedList;

public class Index extends FileCreator{

    LinkedList<String> entries;
    public Index()throws Exception{} //interfaces with DB class, throws exception if index file is already open. calls readEntries
    void readEntries(){}
    boolean isAccountOpen(String accountNo){return false;}
    boolean isCustomerDeactivated(String customerID){return false;}
    String[] getListOfAccounts(String customerID){return null;} //returns a String array of account numbers for a particular customerID
    String getCustomerEntry(String customerID){return null;} //returns null if does not exist
    public void writeCustomerEntry(String customerID,String entry){} //if customerID doesn't not exist in entries, adds new node to LinkedList. if exists, replaces.
    void close(){} //calls writeEntries
    void writeEntries(){}
}
