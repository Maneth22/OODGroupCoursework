package FuelManagementSystem;

public class PetrolDispenser {
	private String VehicleType;
	private double TotalDispenserSales;
	int DispenserNumber;
	private int customerCount;
	private String dispenserName;
	private double Sales;
	private boolean DispenseAvailable;
	private double fuelAmount;
	private final int price=450;
	OctaneFuelDispenseManager OctaneRepo= new OctaneFuelDispenseManager();

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


	public void setSales(double fuelAmount) {
		this.Sales=fuelAmount*price;
		this.TotalDispenserSales+=Sales;
		System.out.println(TotalDispenserSales);


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
		this.DispenseAvailable=DispenseAvailable;
	}
	public void fillVehicle(double fuelAmount){
		setSales(0);
		this.fuelAmount=fuelAmount;
		OctaneRepo.setFuelAmount(fuelAmount);
		System.out.println("Filling "+fuelAmount+"L");
		System.out.println("Remaining Fuel in Octane Repository"+ OctaneRepo.getFuelAmount());
		setSales(fuelAmount);
	}

}