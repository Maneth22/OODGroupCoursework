package FuelManagementSystem;

public class PetrolDispenser {
	private String VehicleType;
	private static double TotalDispenserSales;
	int DispenserNumber;
	private int customerCount;
	private String dispenserName;
	private static double Sales;
	private boolean DispenseAvailable;
	private double fuelAmount;
	private static final int price=450;
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


	public static void setSales(double fuelAmount) {
		Sales=fuelAmount*price;
		TotalDispenserSales+=Sales;		// update sales
		System.out.println(TotalDispenserSales);


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