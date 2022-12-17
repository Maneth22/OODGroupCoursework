package FuelManagementSystem;

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

		this.customerName = customerName;
	}

	public String getVehicleType() {

		return this.vehicleType;
	}


	public void setVehicleType(String vehicleType) {

		this.vehicleType = vehicleType;
	}

	public double getFuelInput() {

		return this.fuelInput;
	}


	public void setFuelInput(double fuelInput) {

		this.fuelInput = fuelInput;
	}

}