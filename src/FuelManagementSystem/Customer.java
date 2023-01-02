package FuelManagementSystem;

import java.io.*;
import java.util.Scanner;

public class Customer implements Serializable {

	private String customerName;
	private int customerNo;
	private String fuelType;
	private String vehicleType;
	private double fuelInput;
	private boolean carFilled;
	private String ticketNo;

	public Customer(String fuelType, double fuelInput, boolean carFilled, String vehicleType,String customerName,String ticketNo) {
		this.fuelType = fuelType;
		this.fuelInput= fuelInput;
		this.carFilled = carFilled;
		this.vehicleType= vehicleType;
		this.customerName=customerName;
		this.ticketNo= ticketNo;
	}

	public String getCustomerName() {

		return this.customerName;
	}

	public void setCustomerName(String customerName) {


		this.customerName = customerName;
	}

	public String getVehicleType() {

		return this.vehicleType;
	}


	public void setVehicleType() {
		Scanner vehType = new Scanner(System.in);
		System.out.println("Enter Vehicle Type :");

		vehicleType = vehType.nextLine();
		System.out.println("Vehicle Type is "+vehicleType);

		this.vehicleType = vehicleType;
	}

	public String getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}

	public double getFuelInput() {

		return this.fuelInput;
	}


	public void setFuelInput(double fuelInput) {
		this.fuelInput = fuelInput;
		//System.out.println("Fuel Type = "+fuelType);


	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public void setCustomerNo() throws IOException {
		BufferedReader reader= new BufferedReader(new FileReader("src\\Resource\\cuscount.txt"));
		String cus=reader.readLine();
		this.customerNo=Integer.parseInt(cus);
		this.customerNo+=1;

		BufferedWriter writer= new BufferedWriter(new FileWriter("src\\Resource\\cuscount.txt"));
		writer.write(String.valueOf(customerNo));
		writer.close();
		reader.close();
	}

	public int getCustomerNo() throws IOException {
		BufferedReader reader= new BufferedReader(new FileReader("src\\Resource\\cuscount.txt"));
		String cus=reader.readLine();
		this.customerNo=Integer.parseInt(cus);
		return customerNo;
	}
	public void InitializeCusCount() throws IOException {
		BufferedWriter writer= new BufferedWriter(new FileWriter("src\\Resource\\cuscount.txt"));
		writer.write(String.valueOf("0"));
		writer.close();
	}



}