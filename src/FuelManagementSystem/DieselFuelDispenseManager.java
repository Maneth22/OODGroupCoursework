package FuelManagementSystem;

import java.io.*;
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
	public void restockFuel(double fuelAmount) throws IOException {
		double NewFuelAmount;
		NewFuelAmount= getFuelAmount()+fuelAmount;

		if (NewFuelAmount < Capacity){
			this.fuelAmount = NewFuelAmount;
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/Resource/fuelAmount.txt"));
			writer.write(String.valueOf(NewFuelAmount));
			writer.close();
		}else {
			System.out.println("Capacity Outbound!");
		}

	}

	public double getFuelAmount() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("src/Resource/fuelAmount.txt"));
		String amount = reader.readLine();
		fuelAmount = Integer.parseInt(amount);

		return this.fuelAmount;
	}

}