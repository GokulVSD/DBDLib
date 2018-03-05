package dbdatabase.customer;

import dbdatabase.DB;

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

    /**the DB class is checked to see if the file pertaining to the customerID is
     * currently open elsewhere; if it is, throws an exception.
     * If not being used, tells DB class that it's going to use the file, and
     * calls readFile().
     * @param customerID: customerID for interacting with customer file.
     * @throws Exception: if file is already open elsewhere.
     */
    public Customer(String customerID) throws Exception {
        if(DB.isCustomerBeingUsed(customerID))
            throw new Exception("File already open, please call object.close() or object.save() after using the object");
        DB.useCustomer(customerID);
        readFile();
        this.customerID = customerID;
    }

    private void readFile(){}
    public String getCustomerDetail(String key){return null;}
    public String getAccount(String accountNo){return null;}
    public String writeAccount(String accountNo,String account){return null;} //if ac exists, replaces, else adds. if account is null, removes account
    public void close(){} //calls writeFile
    private void writeFile(){} //interfaces with DB class
}
