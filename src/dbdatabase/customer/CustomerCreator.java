package dbdatabase.customer;

import dbdatabase.FileCreator;

public class CustomerCreator extends FileCreator {

    public CustomerCreator(String customerID) //calls super's constructor with customerID + ".txt", then calls initCustomerStructure,
    // then calls super's createFile. checks if Index file exists, if not, creates it by passing customerID to IndexCreator.
    // if Index exists, Adds entry with customer status to Index with IndexEntry
    {

        super(customerID + ".txt");
    }
    void initCustomerStructure(){} //edits super's content variable
}
