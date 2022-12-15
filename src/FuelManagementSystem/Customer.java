package FuelManagementSystem;

public class Customer {

	private String customerName;
	private String fuelType;
	private String vehicleType;
	private double fuelInput;
	private boolean carFilled;

	public Customer() {
		// TODO - implement Customer.Customer
		throw new UnsupportedOperationException();
	}

	public String getCustomerName() {
		return this.customerName;
	}

	/**
	 * 
	 * @param customerName
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getVehicleType() {
		return this.vehicleType;
	}

	/**
	 * 
	 * @param vehicleType
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public double getFuelInput() {
		return this.fuelInput;
	}

	/**
	 * 
	 * @param fuelInput
	 */
	public void setFuelInput(double fuelInput) {
		this.fuelInput = fuelInput;
	}

}