package FuelManagementSystem;

import java.io.*;
import java.util.ArrayList;

public class OctaneFuelDispenseManager implements FuelDispenseManager{

	private double fuelAmount;
	private final int Capacity=25000;
	private ArrayList<PetrolDispenser> listOfDispensers = new ArrayList<>();

	public double getFuelAmount() throws IOException {
		BufferedReader reader= new BufferedReader(new FileReader("src/Resource/fuelAmount.txt"));
		String amount=reader.readLine();
		this.fuelAmount=Integer.parseInt(amount);

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
	public void restockFuel(double fuelAmount) throws IOException {
		double NewFuelAmount;
		NewFuelAmount= getFuelAmount()+fuelAmount;
		if (NewFuelAmount <= Capacity){
			this.fuelAmount = NewFuelAmount;
			BufferedWriter writer= new BufferedWriter(new FileWriter("src/Resource/fuelAmount.txt"));
			writer.write(String.valueOf(NewFuelAmount));
			writer.close();
		}else {
			System.out.println("Capacity Outbound!");
		}

	}

}