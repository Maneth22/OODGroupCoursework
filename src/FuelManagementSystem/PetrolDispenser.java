package FuelManagementSystem;

public class PetrolDispenser {
	private String VehicleType;
	int DispenserNumber;
	private int customerCount;
	private String dispenserName;
	private double Sales;
	private boolean DispenseAvailable;

	public int getCustomerCount() {
		return this.customerCount;
	}


	public void setCustomerCount(int customerCount) {
		this.customerCount = customerCount;
	}

	public String getDispenserName() {

		return this.dispenserName;
	}


	public void setDispenserName(String dispenserName) {
		this.dispenserName = dispenserName;
	}

	public double getSales() {
		//calculate and return total dispenser sales
		return Sales;
	}


	public void setSales(double Sales) {
		// update sales
	}

	public PetrolDispenser(int DispenserNumber,String DispenserVehicleType) {
		this.VehicleType= DispenserVehicleType;
		this.DispenserNumber=DispenserNumber;


	}

	public boolean getDispenseAvailable() {
		return DispenseAvailable;
	}


	public void setDispenseAvailable(boolean DispenseAvailable) {
		// change availability of a dispenser
	}

}