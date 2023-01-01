package FuelManagementSystem;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

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
        String fType="petrol";
        if (Objects.equals(dispenser_name, "car") || Objects.equals(dispenser_name, "van")){
            stmt.executeUpdate("INSERT INTO dispenser"+"(dispenser_Type,dispenser_Name,Sales) "
                    +"VALUES ('"+fType+"','"+dispenser_name+"',"+null+")");

        } else if (Objects.equals(dispenser_name, "motorbike")) {
            stmt.executeUpdate("INSERT INTO dispenser"+"(dispenser_Type,dispenser_Name,Sales) "
                    +"VALUES ('"+fType+"','"+dispenser_name+"',"+null+")");

        } else if (Objects.equals(dispenser_name, "threewheel")) {
            stmt.executeUpdate("INSERT INTO dispenser"+"(dispenser_Type,dispenser_Name,Sales) "
                    +"VALUES ('"+fType+"','"+dispenser_name+"',"+null+")");
        }else {
            stmt.executeUpdate("INSERT INTO dispenser"+"(dispenser_Type,dispenser_Name,Sales) "
                    +"VALUES ('"+fType+"','"+dispenser_name+"',"+null+")");

        }



    }

    public void AddDieselDispenserToDB(DieselDispenser dispenser,String Vtype) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();

        String dispenser_name = Vtype;
        String fType = "diesel";
        if (Objects.equals(dispenser_name, "car") || Objects.equals(dispenser_name, "van")) {
            stmt.executeUpdate("INSERT INTO dispenser" + "(dispenser_Type,dispenser_Name,Sales) "
                    + "VALUES ('" + fType + "','" + dispenser_name + "'," + null + ")");

        } else if (Objects.equals(dispenser_name, "publictransport")) {
            stmt.executeUpdate("INSERT INTO dispenser" + "(dispenser_Type,dispenser_Name,Sales) "
                    + "VALUES ('" + fType + "','" + dispenser_name + "'," + null + ")");

        } else if (Objects.equals(dispenser_name, "threewheel")) {
            stmt.executeUpdate("INSERT INTO dispenser" + "(dispenser_Type,dispenser_Name,Sales) "
                    + "VALUES ('" + fType + "','" + dispenser_name + "'," + null + ")");
        } else {
            stmt.executeUpdate("INSERT INTO dispenser" + "(dispenser_Type,dispenser_Name,Sales) "
                    + "VALUES ('" + fType + "','" + dispenser_name + "'," + null + ")");

        }



    }
    public int getQueueCountFromDB(String VehicleType,String fuelType) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();
        int count=0;

        if (fuelType.equals("petrol")){
            if (VehicleType.equals("car") || VehicleType.equals("van")){
                ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM pqueue_carandvan; ");
                rs.next();
                count=rs.getInt(1);


            } else if (VehicleType.equals("motorbike")) {
                ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM pqueue_bike; ");
                rs.next();
                count=rs.getInt(1);


            } else if (VehicleType.equals("threewheel")) {
                ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM pqueue_threewheel; ");
                rs.next();
                count=rs.getInt(1);


            }else {
                ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM pqueue_other; ");
                rs.next();
                count=rs.getInt(1);


            }
        } else if (fuelType.equals("diesel")) {
            if (VehicleType.equals("car") || VehicleType.equals("van")){
                ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM dqueue_carandvan; ");
                rs.next();
                count=rs.getInt(1);


            } else if (VehicleType.equals("motorbike")) {
                ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM dqueue_public; ");
                rs.next();
                count=rs.getInt(1);


            }else {
                ResultSet rs=stmt.executeQuery("SELECT COUNT(*) FROM dqueue_other; ");
                rs.next();
                count=rs.getInt(1);

            }

        }

        return count;
    }

    public void enterTicket(String Name,int ticket_No) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();
        ResultSet rs= stmt.executeQuery("UPDATE `customer`"+ "SET ticket_No='"+ticket_No+"'"+"WHERE customer_Name='"+Name+"'");

    }

}
