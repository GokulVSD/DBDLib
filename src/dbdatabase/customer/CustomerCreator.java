package dbdatabase.customer;

import dbdatabase.FileCreator;

public class CustomerCreator extends FileCreator {

    public CustomerCreator(String customerID){

        super(customerID + ".txt");
    }
}
