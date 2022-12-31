package FuelManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GasStation {

	private double HighestFuelAmountInVehicle;



	public void CalculateIncome(double Income) {

	}

	public void setHighestFuelAmountInVehicle() {

	}

	public void printStatistics() {

	}


	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
		Statement stmt = con.createStatement();



		/*
		Customer customer1= new Customer("petrol", 9,false,"car","fk",null);
		Customer customer2= new Customer("petrol", 9,false,"car","SANA1",null);
		Customer customer3= new Customer("petrol", 9,false,"car","SANA2",null);
		Customer customer4= new Customer("petrol", 9,false,"car","SANA3",null);
		Customer customer5= new Customer("petrol", 9,false,"car","SANA4",null);
		Customer customer6= new Customer("petrol", 9,false,"car","SANA5",null);
		Customer customer7= new Customer("petrol", 9,false,"car","SANA6",null);
		Customer customer8= new Customer("petrol", 9,false,"car","SANA7",null);
		Customer customer9= new Customer("petrol", 9,false,"car","SANA8",null);
		Customer customer10= new Customer("petrol", 9,false,"car","SANA9",null);
		Customer customer11= new Customer("petrol", 9,false,"car","SANA11",null);
		Customer customer12= new Customer("petrol", 9,false,"car","SANA12",null);

		OctaneFuelDispenseManager oD= new OctaneFuelDispenseManager();
		PetrolDispenser PD1= new PetrolDispenser(1,"Car");


		System.out.println(oD.getFuelAmount());

		PD1.fillVehicle(150);
		System.out.println(oD.getFuelAmount());
		Queue carQ= new Queue();
		carQ.Enqueue(customer1);
		carQ.Enqueue(customer2);
		carQ.Enqueue(customer3);
		carQ.Enqueue(customer4);
		carQ.Enqueue(customer5);
		carQ.Enqueue(customer6);
		carQ.Enqueue(customer7);
		carQ.Enqueue(customer8);
		carQ.Enqueue(customer9);
		carQ.Enqueue(customer10);
		carQ.Enqueue(customer11);
		carQ.Dequeue();
		carQ.Enqueue(customer12);*/



		System.out.println("        ***********************************************************");
		System.out.println("                  WELCOME TO THE FUEL MANAGEMENT SYSTEM          ");
		System.out.println("        ***********************************************************");

		OptionMenu op = new OptionMenu();
		op.MainMenuDisplay();



	}

}