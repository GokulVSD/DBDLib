package dbdatabase;

import dbdatabase.account.AccountCreator;
import dbdatabase.customer.CustomerCreator;
import dbdatabase.index.Index;
import dbdatabase.index.IndexEntry;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

public class DBD {

    private File file;
    public boolean status;

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

    public void createNewCustomer(String customerID){
        while (true) {
            try {
                new CustomerCreator(customerID);
            } catch (Exception e) {
                if(shouldIWait(e.getMessage())){
                    if(!waiting()){
                        status = false;
                        return;
                    }
                    continue;
                }
                appendDBDLog(e.getMessage());
                status = false;
                return;
            }
            status = true;
            return;
        }
    }

    public void createNewAccount(String customerID,String accountNo) {
        while (true) {
            try {
                new AccountCreator(customerID, accountNo);
            } catch (Exception e) {
                if (shouldIWait(e.getMessage())) {
                    if (!waiting()) {
                        status = false;
                        return;
                    }
                    continue;
                }
                appendDBDLog(e.getMessage());
                status = false;
                return;
            }
            status = true;
            return;
        }
    }

    public boolean isAccountOpen(String accountNo){
        while (true) {
            try {
                boolean flag;
                Index i = new Index();
                flag = i.isAccountOpen(accountNo);
                i.close();
                status = true;
                return flag;

            } catch (Exception e) {
                if (shouldIWait(e.getMessage())) {
                    if (!waiting()) {
                        status = false;
                        return false;
                    }
                    continue;
                }
                appendDBDLog(e.getMessage());
                status = false;
                return false;
            }
        }
    }

    public boolean doesAccountExist(String accountNo){
        while (true) {
            try {
                boolean flag;
                Index i = new Index();
                flag = i.doesAccountExist(accountNo);
                i.close();
                status = true;
                return flag;

            } catch (Exception e) {
                if (shouldIWait(e.getMessage())) {
                    if (!waiting()) {
                        status = false;
                        return false;
                    }
                    continue;
                }
                appendDBDLog(e.getMessage());
                status = false;
                return false;
            }
        }
    }

    public boolean isCustomerDeactivated(String customerID){
        while (true) {
            try {
                boolean flag;
                Index i = new Index();
                flag = i.isCustomerDeactivated(customerID);
                i.close();
                status = true;
                return flag;

            } catch (Exception e) {
                if (shouldIWait(e.getMessage())) {
                    if (!waiting()) {
                        status = false;
                        return false;
                    }
                    continue;
                }
                appendDBDLog(e.getMessage());
                status = false;
                return false;
            }
        }
    }

    public boolean doesCustomerExist(String customerID){
        while (true) {
            try {
                boolean flag;
                Index i = new Index();
                flag = i.doesCustomerExist(customerID);
                i.close();
                status = true;
                return flag;

            } catch (Exception e) {
                if (shouldIWait(e.getMessage())) {
                    if (!waiting()) {
                        status = false;
                        return false;
                    }
                    continue;
                }
                appendDBDLog(e.getMessage());
                status = false;
                return false;
            }
        }
    }

    public String[] getListofAccounts(String customerID){
        while (true) {
            try {
                String[] var;
                Index i = new Index();
                var = i.getListOfAccounts(customerID);
                i.close();
                status = true;
                return var;

            } catch (Exception e) {
                if (shouldIWait(e.getMessage())) {
                    if (!waiting()) {
                        status = false;
                        return null;
                    }
                    continue;
                }
                appendDBDLog(e.getMessage());
                status = false;
                return null;
            }
        }
    }

    public void closeAccount(String customerID,String accountNo){
        while (true) {
            try {
                IndexEntry iE = new IndexEntry(customerID);
                iE.closeAccount(accountNo);
                iE.save();
            } catch (Exception e) {
                if (shouldIWait(e.getMessage())) {
                    if (!waiting()) {
                        status = false;
                        return;
                    }
                    continue;
                }
                appendDBDLog(e.getMessage());
                status = false;
                return;
            }
            status = true;
            return;
        }
    }

    public void reopenAccount(String customerID,String accountNo){
        while (true) {
            try {
                IndexEntry iE = new IndexEntry(customerID);
                iE.reopenAccount(accountNo);
                iE.save();
            } catch (Exception e) {
                if (shouldIWait(e.getMessage())) {
                    if (!waiting()) {
                        status = false;
                        return;
                    }
                    continue;
                }
                appendDBDLog(e.getMessage());
                status = false;
                return;
            }
            status = true;
            return;
        }
    }

    public void activateCustomer(String customerID){
        while (true) {
            try {
                IndexEntry iE = new IndexEntry(customerID);
                iE.activateCustomer();
                iE.save();
            } catch (Exception e) {
                if (shouldIWait(e.getMessage())) {
                    if (!waiting()) {
                        status = false;
                        return;
                    }
                    continue;
                }
                appendDBDLog(e.getMessage());
                status = false;
                return;
            }
            status = true;
            return;
        }
    }

    public void deactivateCustomer(String customerID){
        while (true) {
            try {
                IndexEntry iE = new IndexEntry(customerID);
                iE.deactivateCustomer();
                iE.save();
            } catch (Exception e) {
                if (shouldIWait(e.getMessage())) {
                    if (!waiting()) {
                        status = false;
                        return;
                    }
                    continue;
                }
                appendDBDLog(e.getMessage());
                status = false;
                return;
            }
            status = true;
            return;
        }
    }
}
