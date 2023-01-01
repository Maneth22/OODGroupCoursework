package FuelManagementSystem;

import java.util.ArrayList;

public class DieselFuelDispenseManager implements FuelDispenseManager{

	private double fuelAmount;
	private final int Capacity=25000;
	private ArrayList<DieselDispenser> listOfDispensers;

	public boolean createDispenser(int DispenserNumber, String DispenserVehicleType){
		return this.listOfDispensers.add(new DieselDispenser(DispenserNumber,DispenserVehicleType));
	}

	public void setFuelAmount(double DfuelAmount) {

		if (this.fuelAmount<500){
			System.out.println("Diesel Fuel limit less than 500L,\n Please Restock fuel to continue");
		}else {
			this.fuelAmount-=DfuelAmount;

		}

	}

	@Override
	public double checkFuelAmount() {

		return fuelAmount;
	}

	@Override
	public void restockFuel(double fuelAmount) {
		double NewFuelAmount;
		NewFuelAmount= getFuelAmount()+fuelAmount;

		if (NewFuelAmount < Capacity){
			this.fuelAmount = NewFuelAmount;
			// overwritewrite fuel amount text file
		}else {
			System.out.println("Capacity Outbound!");
		}

	}

	public double getFuelAmount() {
		//read current fuel amount text file
		return this.fuelAmount;
	}

}