package FuelManagementSystem;

public class DieselDispenser {

	private int customerCount;
	private int DispenserNumber;
	private String VehicleType;
	private String dispenserName;
	private double Sales;
	private boolean DispenserAvailable;



	public String getDispenserName() {
		return this.dispenserName;
	}

	public void setDispenserName(String dispenserName) {
		this.dispenserName = dispenserName;
	}

	public double getSales() {
		return Sales;
	}


	public void setSales(double Sales) {
		//update sales
	}


	public void setCustomerCount(int customerCount) {
		this.customerCount = customerCount;
	}

	public void getCustomerCount() {
	}

	public DieselDispenser(int DispenserNumber,String VehicleType) {
		this.DispenserNumber= DispenserNumber;
		this.VehicleType= VehicleType;
	}

	public boolean getDispenserAvailable() {
		return DispenserAvailable;
	}

	public void setDispenserAvailable(boolean DispenserAvailable) {
		// change availability of a dispenser
	}

}