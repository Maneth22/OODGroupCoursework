package FuelManagementSystem;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

import static java.lang.System.out;

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
    public void ViewDispensers() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();
        int count=0;
        ResultSet rs = stmt.executeQuery("SELECT * FROM `dispenser` ");
        while (rs.next()) {
            count+=1;
            String name = rs.getString("dispenser_Name");
            String Type = rs.getString("dispenser_Type");


            System.out.println("["+count+"]"+"\t"+name + "\t" + Type + "\t" +"\n");

        }
    }
    public Customer getLastCustomerFromDB() throws SQLException, ClassNotFoundException {
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
        int TicketNo=ticket_No;
        stmt.executeUpdate("UPDATE `customer`"+ "SET ticket_No='"+TicketNo+"'"+"WHERE customer_Name='"+Name+"'");

    }
    public void addCustomerToQueue(Customer customer) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();

        String Type=customer.getVehicleType();
        String Name_= customer.getCustomerName();
        int fuelAmount=(int)customer.getFuelInput();
        if (customer.getFuelType().equals("petrol")){


            if (Type.equals("car") || Type.equals("van")){
                stmt.executeUpdate("INSERT INTO pqueue_carandvan"+"(customer_Name,fuel_Amount) "
                        +"VALUES ('"+Name_+"',"+fuelAmount+")");


            } else if (Type.equals("motorbike")) {
                stmt.executeUpdate("INSERT INTO pqueue_bike"+"(customer_Name,fuel_Amount) "
                        +"VALUES ('"+Name_+"',"+fuelAmount+")");

            } else if (Type.equals("threewheel")) {
                stmt.executeUpdate("INSERT INTO pqueue_threewheel"+"(customer_Name,fuel_Amount) "
                        +"VALUES ('"+Name_+"',"+fuelAmount+")");

            }else {
                stmt.executeUpdate("INSERT INTO pqueue_other"+"(customer_Name,fuel_Amount) "
                        +"VALUES ('"+Name_+"',"+fuelAmount+")");

            }


        } else if (customer.getFuelType().equals("diesel")) {

            if (Type.equals("car") || Type.equals("van")){
                stmt.executeUpdate("INSERT INTO dqueue_carandvan"+"(customer_Name,fuel_Amount) "
                        +"VALUES ('"+Name_+"',"+fuelAmount+")");


            } else if (Type.equals("publictransport")) {
                stmt.executeUpdate("INSERT INTO dqueue_public"+"(customer_Name,fuel_Amount) "
                        +"VALUES ('"+Name_+"',"+fuelAmount+")");


            }else {
                stmt.executeUpdate("INSERT INTO dqueue_other"+"(customer_Name,fuel_Amount) "
                        +"VALUES ('"+Name_+"',"+fuelAmount+")");


            }
        }
        else{
            System.out.println("please Enter Again");
        }
        out.println("added to queue");
    }


    public void RemoveVehicleFromQueueDB(Customer customer,String queuType) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();


        String cus_Name=customer.getCustomerName();


            if (queuType.equals("pqueue_carandvan")){
                stmt.executeUpdate("DELETE FROM pqueue_carandvan WHERE Customer_Name='"+cus_Name+"'");


            } else if (queuType.equals("pqueue_bike")) {
                stmt.executeUpdate("DELETE FROM pqueue_bike WHERE Customer_Name='"+cus_Name+"'");


            } else if (queuType.equals("pqueue_threewheel")) {
                stmt.executeUpdate("DELETE FROM pqueue_threewheel WHERE Customer_Name='"+cus_Name+"'");


            }else if (queuType.equals("pqueue_other")){
                stmt.executeUpdate("DELETE FROM pqueue_other WHERE Customer_Name='"+cus_Name+"'");


            }
            else if (queuType.equals("dqueue_carandvan")){
                stmt.executeUpdate("DELETE FROM dqueue_carandvan WHERE Customer_Name='"+cus_Name+"'");



            } else if (queuType.equals("dqueue_public")) {
                stmt.executeUpdate("DELETE FROM dqueue_public WHERE Customer_Name='"+cus_Name+"'");



            }else if (queuType.equals("dqueue_other")){
                stmt.executeUpdate("DELETE FROM dqueue_other WHERE Customer_Name='"+cus_Name+"'");



            } else  {
                out.println("unable to find expected queue");

            }


    }
    public void Viewtables(String queueType) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();
        Payment payment= new Payment();
        double cost=0;

        ResultSet rs = stmt.executeQuery("SELECT * FROM `"+queueType+"` ");
        String Name=null;
        double fuelAmount=0;

        while (rs.next()) {
            Name=rs.getString("customer_Name");
            fuelAmount=rs.getInt("fuel_Amount");

            out.println("+ "+ Name+"\t"+fuelAmount+"\n");
        }
    }


}
