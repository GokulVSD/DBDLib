package dbdatabase.index;

import dbdatabase.FileCreator;

//this class has not been tested
public class IndexCreator extends FileCreator {

    public IndexCreator(String customerID){
        super("index.txt");
        initIndexStructure(customerID);
        super.createFile();
    }

    void initIndexStructure(String customerID){
        super.content = customerID + ":" + "activated" + ":" + ",";
    }
}
