package dbdatabase.customer;

public class CustomerEditor extends Customer {

    public CustomerEditor(String customerID)throws Exception {

        super(customerID);
    }
    void editCustomerDetail(String key,String value){}
    void save(){} //calls super's close
}
