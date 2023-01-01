package FuelManagementSystem;

import java.io.IOException;

public class DieselDispenser {

	private int customerCount;
	private double fuelAmount;
	private int DispenserNumber;
	private String VehicleType;
	private String dispenserName;
	private double Sales;
	private boolean DispenserAvailable;

	DieselFuelDispenseManager DieselRepo= new DieselFuelDispenseManager();



	public String getDispenserName() {
		return this.dispenserName;
	}

	public void setDispenserName(String dispenserName) {
		this.dispenserName = dispenserName;
	}

	public double getSales() {
		return Sales;
	}

	public double getFuelAmount() {
		return fuelAmount;
	}

	public void setSales(double Sales) {
		//update sales
	}


	public void setCustomerCount(int customerCount) {
		this.customerCount = customerCount;
	}

	public void getCustomerCount() {
	}

	public DieselDispenser(String VehicleType) {
		this.VehicleType= VehicleType;
	}

	public boolean getDispenserAvailable()
	{
		return DispenserAvailable;
	}

	public void setDispenserAvailable(boolean DispenserAvailable) {
		// change availability of a dispenser
	}
	public void fillVehicle(double fuelAmount) throws IOException {
		setSales(0);
		this.fuelAmount=fuelAmount;
		DieselRepo.setFuelAmount(fuelAmount);
		System.out.println("Filling "+fuelAmount+"L");
		System.out.println("Remaining Fuel in Diesel Repository"+ DieselRepo.getFuelAmount());
		setSales(fuelAmount);

	}

}