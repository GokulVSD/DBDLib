package dbdatabase.index;

import dbdatabase.FileCreator;

public class IndexCreator extends FileCreator {

    public IndexCreator(String customerID)//calls super's constructor with "index.txt", calls initIndexStructure, then calls super's
    // createFile.
    {

        super("index.txt");
    }

    void initIndexStructure(String customerID){} //sets super's content variable with one entry as customerID with the customer status
    // as deactivated=false
}
