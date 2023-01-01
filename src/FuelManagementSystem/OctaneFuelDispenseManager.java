package FuelManagementSystem;

import java.util.ArrayList;

public class OctaneFuelDispenseManager implements FuelDispenseManager{

	private double fuelAmount;
	private final int Capacity=25000;
	private ArrayList<PetrolDispenser> listOfDispensers = new ArrayList<>();

	public double getFuelAmount() {

		return fuelAmount;
	}
	public boolean createdDispensers(String DispenserVehicleType){
		return this.listOfDispensers.add(new PetrolDispenser(DispenserVehicleType));
	}



	public void setFuelAmount(double SfuelAmount) {
		if (this.fuelAmount<500){
			System.out.println("Octane Fuel limit less than 500L,\n Please Restock fuel to continue");
		}else {
			this.fuelAmount-=SfuelAmount;

		}
	}

	@Override
	public double checkFuelAmount() {

		return this.fuelAmount;
	}

	@Override
	public void restockFuel(double fuelAmount) {
		double NewFuelAmount;
		NewFuelAmount= getFuelAmount()+fuelAmount;
		if (NewFuelAmount <= Capacity){
			this.fuelAmount = NewFuelAmount;
		}else {
			System.out.println("Capacity Outbound!");
		}

	}

}