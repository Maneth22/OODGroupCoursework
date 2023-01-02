package FuelManagementSystem;

import java.io.*;
import java.util.ArrayList;

public class OctaneFuelDispenseManager implements FuelDispenseManager{

	private double fuelAmount;
	private final int Capacity=25000;
	private ArrayList<PetrolDispenser> listOfDispensers = new ArrayList<>();


	public boolean createdDispensers(String DispenserVehicleType){
		return this.listOfDispensers.add(new PetrolDispenser(DispenserVehicleType));
	}



	public void setFuelAmount(double SfuelAmount) throws IOException {
		BufferedReader reader= new BufferedReader(new FileReader("src\\Resource\\petrolAmount.txt"));
		String cus=reader.readLine();
		this.fuelAmount=Integer.parseInt(cus);
		if (this.fuelAmount<500){
			System.out.println("Octane Fuel limit less than 500L,\n Please Restock fuel to continue");
		}else {
			this.fuelAmount-=SfuelAmount;
			BufferedWriter writer= new BufferedWriter(new FileWriter("src\\Resource\\petrolAmount.txt"));
			writer.write(String.valueOf((int)fuelAmount));
			writer.close();

		}
	}

	@Override
	public double checkFuelAmount() {

		return this.fuelAmount;
	}

	@Override
	public void restockFuel(double fuelAmount) throws IOException {
		double NewFuelAmount;

		BufferedReader reader= new BufferedReader(new FileReader("src\\Resource\\petrolAmount.txt"));
		String cus=reader.readLine();

		this.fuelAmount=Integer.parseInt(cus);
		NewFuelAmount= getFuelAmount()+fuelAmount;
		reader.close();

		if (NewFuelAmount < Capacity){

			BufferedWriter writer= new BufferedWriter(new FileWriter("src\\Resource\\petrolAmount.txt"));
			writer.write(String.valueOf((int)NewFuelAmount));
			writer.close();

		}else {
			System.out.println("Capacity Outbound!");
		}
	}
	public double getFuelAmount() throws IOException {
		BufferedReader reader= new BufferedReader(new FileReader("src\\Resource\\petrolAmount.txt"));
		String cus=reader.readLine();
		this.fuelAmount=Integer.parseInt(cus);
		//read current fuel amount text file
		return this.fuelAmount;
	}

}