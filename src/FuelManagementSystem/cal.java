package FuelManagementSystem;

import java.io.IOException;
import java.sql.SQLException;

public class cal {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        DBConnector db = new DBConnector();
        //Customer customer;
        //System.out.println(db.getQueueCountFromDB());
        //int cus_count=db.getQueueCountFromDB("car","petrol");
        //System.out.println(cus_count);
        DieselFuelDispenseManager d= new DieselFuelDispenseManager();
        d.setFuelAmount(300);

    }
}
