package FuelManagementSystem;

public class GasStation {

	private double HighestFuelAmountInVehicle;



	public void CalculateIncome(double Income) {

	}

	public void setHighestFuelAmountInVehicle() {

	}

	public void printStatistics() {

	}

	public static void main(String[] args) {


		OctaneFuelDispenseManager oD= new OctaneFuelDispenseManager();
		oD.restockFuel(20000);
		System.out.println(oD.getFuelAmount());
		oD.setFuelAmount(2400);
		System.out.println(oD.getFuelAmount());
	}

}