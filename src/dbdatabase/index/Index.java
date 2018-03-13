package dbdatabase.index;

import dbdatabase.DB;
import dbdatabase.FileCreator;

import java.io.File;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

//this class has not been tested
public class Index extends FileCreator{

    LinkedList<String> entries;
    public Index()throws Exception{
        super("index.txt");
        if(DB.isIndexBeingUsed())
            throw new Exception("DBDatabase: Index file already open, please call object.close() or object.save() after using the object");
        DB.useIndex();
        entries = new LinkedList();
        readEntries();
    }

    void readEntries()throws Exception{
        String homeDir = System.getProperty("user.home");
        String dir = homeDir + File.separator + "Documents" + File.separator + "DBDatabase";
        File file = new File(dir, "index.txt");
        Scanner sc;
        try {
            sc = new Scanner(file);
        } catch (Exception e){
            DB.doneUsingIndex();
            throw new Exception("DBDatabase: Index file does not exist");
        }
        sc.useDelimiter("\\Z");
        String content = sc.next().trim();
        StringTokenizer st = new StringTokenizer(content,",");
        while(st.hasMoreTokens())
            entries.add(st.nextToken().trim());
    }
    boolean isAccountOpen(String accountNo){
        for(String s:entries){
            StringTokenizer st = new StringTokenizer(s,":");
            st.nextToken(); st.nextToken();
            while(st.hasMoreTokens()){
                if(st.nextToken().equals(accountNo)){
                    if(st.nextToken().equals("open")) return true;
                    else return false;
                }
                st.nextToken();
            }
        }
        return false;
    }
    boolean isCustomerDeactivated(String customerID){
        for(String s:entries){
            StringTokenizer st = new StringTokenizer(s,":");
            if(st.nextToken().equals(customerID)){
                if(st.nextToken().equals("deactivated")) return true;
                else return false;
            }
        }
        return true;
    }
    String[] getListOfAccounts(String customerID){
        for(String s:entries){
            StringTokenizer st = new StringTokenizer(s,":");
            if(st.nextToken().equals(customerID)){
                st.nextToken();
                LinkedList<String> listOfAccounts = new LinkedList();
                while (st.hasMoreTokens()){
                    listOfAccounts.add(st.nextToken());
                    st.nextToken();
                }
                return listOfAccounts.toArray(new String[listOfAccounts.size()]);
            }
        }
        return null;
    }
    String getCustomerEntry(String customerID){
        for(String s:entries){
            StringTokenizer st = new StringTokenizer(s,":");
            if(st.nextToken().equals(customerID)) return s;
        }
        return null;
    }
    public void writeCustomerEntry(String customerID,String entry){
        for(String s:entries){
            StringTokenizer st = new StringTokenizer(s,":");
            if(st.nextToken().equals(customerID)){
                entries.removeFirstOccurrence(s);
                entries.add(entry);
                return;
            }
        }
        entries.add(entry);
    }
    void close(){
        writeEntries();
    }
    void writeEntries(){
        super.content = "";
        for(String s:entries)
            super.content += s + ",";
        super.createFile();
        DB.doneUsingIndex();
    }
}
