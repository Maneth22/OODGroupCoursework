package FuelManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GasStation {



	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
		Statement stmt = con.createStatement();






		System.out.println("        ***********************************************************");
		System.out.println("                  WELCOME TO THE FUEL MANAGEMENT SYSTEM          ");
		System.out.println("        ***********************************************************");

		OptionMenu op = new OptionMenu();

		op.MainMenuDisplay();



	}

}