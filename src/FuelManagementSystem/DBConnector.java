package FuelManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
    public void AddCusToDB(Customer customer) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();

        customer.setCustomerNo();
        int cus_num= customer.getCustomerNo();
        String Name_= customer.getCustomerName();
        String fueltype= customer.getFuelType();
        double fuelAmount=customer.getFuelInput();
        String vehicle=customer.getVehicleType();



        stmt.executeUpdate("INSERT INTO customer"+"(customer_No, customer_Name,vehicle_Type,fuel_Type,fuel_Amount,ticket_No,payment) "
                +"VALUES ("+cus_num+",'"+Name_+"','"+vehicle+"','"+fueltype+"',"+fuelAmount+","+null+","+null+")");



    }
    public void ViewCusFromDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();


    }

}
