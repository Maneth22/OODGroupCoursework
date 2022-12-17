package FuelManagementSystem;

import java.util.Scanner;

public class Customer {

	private String customerName;
	private String fuelType;
	private String vehicleType;
	private double fuelInput;
	private boolean carFilled;

	public Customer(String fuelType, boolean carFilled, String vehicleType,String customerName) {
		this.fuelType = fuelType;
		this.carFilled = carFilled;
		this.vehicleType= vehicleType;
		this.customerName=customerName;
	}

	public String getCustomerName() {

		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		Scanner cusName = new Scanner(System.in);
		System.out.println("Enter Customer Name :");

		customerName = cusName.nextLine();
		System.out.println("Customers name is "+customerName);

		this.customerName = customerName;
	}

	public String getVehicleType() {

		return this.vehicleType;
	}


	public void setVehicleType(String vehicleType) {
		Scanner vehType = new Scanner(System.in);
		System.out.println("Enter Vehicle Type :");

		vehicleType = vehType.nextLine();
		System.out.println("Vehicle Type is "+customerName);

		this.vehicleType = vehicleType;
	}

	public double getFuelInput() {

		return this.fuelInput;
	}


	public void setFuelInput(double fuelInput) {
		Scanner fuelType = new Scanner(System.in);
		System.out.println("Enter Vehicles Fuel Type :");


		String temp = fuelType.nextLine();
		fuelInput = Double.parseDouble(temp);
		System.out.println("Vehicle Type is "+customerName);

		this.vehicleType = vehicleType;

		this.fuelInput = fuelInput;
	}

}