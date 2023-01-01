package FuelManagementSystem;

import java.io.IOException;
import java.sql.*;

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



        stmt.executeUpdate("INSERT INTO customer"+"(customer_Name,vehicle_Type,fuel_Type,fuel_Amount,ticket_No,payment) "
                +"VALUES ('"+Name_+"','"+vehicle+"','"+fueltype+"',"+fuelAmount+","+null+","+null+")");



    }
    public void ViewCusFromDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();

        ResultSet rs= stmt.executeQuery("SELECT * FROM `customer` ");
        while (rs.next()){
            String name= rs.getString("customer_Name");
            String vehicle= rs.getString("vehicle_Type");
            String fueltype= rs.getString("fuel_Type");
            int fuelamount= rs.getInt("fuel_Amount");

            System.out.println(name+"\t"+vehicle+"\t"+fueltype+"\t"+fuelamount+"L\n");
        }


    }
    public Customer getCustomerFromDB() throws SQLException, ClassNotFoundException {
        String name = null;
        String vehicle = null;
        String fueltype = null;
        int fuelamount = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery("SELECT * FROM `customer` ORDER BY customer_No DESC LIMIT 1");

        while (rs.next()){
            name= rs.getString("customer_Name");
            vehicle= rs.getString("vehicle_Type");
            fueltype= rs.getString("fuel_Type");
            fuelamount= rs.getInt("fuel_Amount");

        }
        Customer customer= new Customer(fueltype,fuelamount,false,
                vehicle,name,null);
        return customer;

    }
    public void AddPetrolDispenserToDB(PetrolDispenser dispenser,String Vtype) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();

        String dispenser_name= Vtype;
        //if (dispenser_name==)




        //stmt.executeUpdate("INSERT INTO customer"+"(customer_Name,vehicle_Type,fuel_Type,fuel_Amount,ticket_No,payment) "
               // +"VALUES ('"+Name_+"','"+vehicle+"','"+fueltype+"',"+fuelAmount+","+null+","+null+")");



    }

}
