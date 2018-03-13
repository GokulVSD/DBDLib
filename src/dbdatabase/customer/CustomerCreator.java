package dbdatabase.customer;

import dbdatabase.FileCreator;
import dbdatabase.index.IndexCreator;
import dbdatabase.index.IndexEntry;

//this class hasn't been tested yet
public class CustomerCreator extends FileCreator {

    public CustomerCreator(String customerID) throws Exception {
        super(customerID + ".txt");
        initCustomerStructure();
        try{
            new IndexEntry(customerID);
        } catch (Exception e){
            if(e.getMessage().equals("DBDatabase: Index file already open, please call object.close() or object.save() after using the object"))
                throw new Exception("DBDatabase: Can't create new customer since Index file is currently being used");
            if(e.getMessage().equals("DBDatabase: Index file does not exist"))
                new IndexCreator(customerID);
        }
        super.createFile();
    }

    private void initCustomerStructure(){
        super.content = ";" + "|" + ";" + "|";
    }
}
