package dbdatabase.customer;

import dbdatabase.DB;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Customer {

    protected String customerID;
    protected String details;
    protected String accounts;

    /**
     * the DB class is checked to see if the file pertaining to the customerID is
     * currently open elsewhere; if it is, throws an exception.
     * If not being used, tells DB class that it's going to use the file, and
     * calls readFile().
     *
     * @param customerID: customerID for interacting with customer file.
     * @throws Exception: if file is already open.
     */
    public Customer(String customerID) throws Exception {
        if (DB.isCustomerBeingUsed(customerID))
            throw new Exception("DBDatabase: File already open, please call object.close() or object.save() after using the object");
        DB.useCustomer(customerID);
        this.customerID = customerID;
        readFile();
    }

    private void readFile() throws Exception {
        String homeDir = System.getProperty("user.home");
        String dir = homeDir + File.separator + "Documents" + File.separator + "DBDatabase";
        File file = new File(dir, customerID + ".txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (Exception e){
            throw new Exception("DBDatabase: Customer file does not exist");
        }
        sc.useDelimiter("\\Z");
        String content = sc.next();
        StringTokenizer st = new StringTokenizer(content, "|");
        details = st.nextToken().trim();
        accounts = st.nextToken().trim();
    }

    public String getCustomerDetail(String key) {
        StringTokenizer st = new StringTokenizer(details,";");
        String token;
        while(st.hasMoreTokens()){
            token = st.nextToken().trim();
            StringTokenizer stSub = new StringTokenizer(token,":");
            if(stSub.nextToken().equals(key)) return stSub.nextToken().trim();
        }
        return null;
    }

    public String getAccount(String accountNo){
        StringTokenizer st = new StringTokenizer(accounts,";");
        String token;
        while(st.hasMoreTokens()){
            token = st.nextToken().trim();
            StringTokenizer stSub = new StringTokenizer(token,":");
            if(stSub.nextToken().equals(accountNo)) return stSub.nextToken().trim();
        }
        return null;
    }

    public void writeAccount(String accountNo, String account) {
        StringTokenizer st = new StringTokenizer(accounts,";");
        accounts = "";
        boolean accountExists = false;
        String token;
        while(st.hasMoreTokens()){
            token = st.nextToken().trim();
            if(token.substring(0,token.indexOf(":")).equals(accountNo)){
                accountExists = true;
                if(account == null) break;
                token = accountNo + ":" + account;
            }
            accounts += token + ";";
        }
        while(st.hasMoreTokens()){
            token = st.nextToken().trim();
            accounts += token + ";";
        }
        if(!accountExists) accounts += accountNo + ":" + account + ";";
    } //if ac exists, replaces, else adds. if account is null, removes account.

    public void close() {
        writeFile();
    } //calls writeFile

    private void writeFile() {

        DB.doneUsingCustomer(customerID);
    } //interfaces with DB class
}