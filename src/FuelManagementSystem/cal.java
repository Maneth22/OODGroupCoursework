package FuelManagementSystem;

import java.io.IOException;
import java.sql.SQLException;

public class cal {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        DBConnector db = new DBConnector();
        Customer customer;
        customer=db.getCustomerFromDB();
        System.out.println(customer.getCustomerName());
    }
}
