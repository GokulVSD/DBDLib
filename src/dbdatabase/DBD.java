package dbdatabase;

import dbdatabase.account.AccountCreator;
import dbdatabase.customer.CustomerCreator;
import dbdatabase.index.Index;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class DBD {

    File file;

    public DBD(){
        String homeDir = System.getProperty("user.home");
        String dir = homeDir + File.separator + "Documents" + File.separator + "DBDatabase";
        file = new File(dir,"DBLogs.txt");
    }

    private boolean appendDBDLog(String s){
        try {
            FileWriter fW = new FileWriter(file,true);
            String time = "" + LocalDateTime.now();
            fW.write(time.substring(0,time.indexOf("T")) + "\t" + time.substring(time.indexOf("T") + 1,time.lastIndexOf(".")) + ": " + s + "\n");
            fW.close();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private boolean shouldIWait(String s){
        switch (s){
            case "DBDatabase: Index file already open, please call object.close() or object.save() after using the object":
            case "DBDatabase: Customer file already open, please call object.close() or object.save() after using the object": return true;
        }
        return false;
    }

    private boolean waiting(){
        try {
            Thread.sleep(10);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    public boolean createNewCustomer(String customerID){
        while (true) {
            try {
                new CustomerCreator(customerID);
            } catch (Exception e) {
                if(shouldIWait(e.getMessage())){
                    if(!waiting()) return false;
                    continue;
                }
                appendDBDLog(e.getMessage());
                return false;
            }
            return true;
        }
    }

    public boolean createNewAccount(String customerID,String accountNo){
        while (true) {
            try {
                new CustomerCreator(customerID);
            } catch (Exception e) {
                if(shouldIWait(e.getMessage())){
                    if(!waiting()) return false;
                    continue;
                }
                appendDBDLog(e.getMessage());
                return false;
            }
            return true;
        }
    }

    public boolean isAccountOpen(String accountNo){
        Index i;
        try{
            i = new Index();
        }
    }
}
