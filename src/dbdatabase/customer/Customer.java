package dbdatabase.customer;

/**
 * Customer ID
 * Reads Customer file
 * Insert at Details section(key)
 * Insert at Accounts section(key)
 * Retrieve Account info(Account No)
 * Retrieve Detail(key)
 */
public class Customer {

    protected String customerID;
    protected String details;
    protected String accounts;

    public Customer(String customerID) throws Exception //interfaces with DB class, throws exception if customer file is already open. calls readFile//
    {

        this.customerID = customerID;
    }

    void readFile();
    String getCustomerDetail(String key);
    String getAccount(String accountNo);
    String writeAccount(String accountNo,String account); //if ac exists, replaces, else adds. if account is null, removes account
    void close(); //calls writeFile
    void writeFile(); //interfaces with DB class
}
