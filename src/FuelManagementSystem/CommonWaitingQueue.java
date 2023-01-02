package FuelManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CommonWaitingQueue {


	private ArrayList<Customer> customers=new ArrayList<Customer>();

	CommonWaitingQueue() {
		super();
	}


	public void wait(Customer Element) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
		Statement stmt = con.createStatement();


		String Name_= Element.getCustomerName();
		String fueltype= Element.getFuelType();
		double fuelAmount=Element.getFuelInput();
		String vehicle=Element.getVehicleType();



		stmt.executeUpdate("INSERT INTO common_queue"+"(customer_Name,vehicle_Type,fuel_Type,fuel_Amount,ticket_No,payment) "
				+"VALUES ('"+Name_+"','"+vehicle+"','"+fueltype+"',"+fuelAmount+","+null+","+null+")");


		this.customers.add(Element);
		System.out.println(Element.getCustomerName()+" added to common  waiting");
	}
	public boolean chcklist(){
		return customers.isEmpty();
	}
	public int size(){
		return customers.size();
	}
	public void remove(){
		customers.remove(0);
	}

	public Customer parsing() {
		System.out.println(customers.get(0).getCustomerName()+" Removing from common waiting");
		return customers.get(0);

	}



}
