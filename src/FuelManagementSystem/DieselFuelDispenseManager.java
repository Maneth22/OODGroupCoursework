package FuelManagementSystem;

import java.io.*;
import java.util.ArrayList;

public class DieselFuelDispenseManager implements FuelDispenseManager{

	private double fuelAmount;
	private final int Capacity=25000;
	private ArrayList<DieselDispenser> listOfDispensers;

	public boolean createDispenser(String DispenserVehicleType){
		return this.listOfDispensers.add(new DieselDispenser(DispenserVehicleType));
	}

	public void setFuelAmount(double DfuelAmount) throws IOException {
		BufferedReader reader= new BufferedReader(new FileReader("src\\Resource\\dieselAmount.txt"));
		String cus=reader.readLine();
		this.fuelAmount=Integer.parseInt(cus);
		if (fuelAmount<500){
			System.out.println("Diesel Fuel limit less than 500L,\n Please Restock fuel to continue");
		}else {
			this.fuelAmount-=DfuelAmount;
			BufferedWriter writer= new BufferedWriter(new FileWriter("src\\Resource\\dieselAmount.txt"));
			writer.write(String.valueOf((int)fuelAmount));
			writer.close();

		}

	}

	@Override
	public double checkFuelAmount() {

		return fuelAmount;
	}

	@Override
	public void restockFuel(double fuelAmount) throws IOException {
		double NewFuelAmount;



		BufferedReader reader= new BufferedReader(new FileReader("src\\Resource\\dieselAmount.txt"));
		String cus=reader.readLine();
		this.fuelAmount=Integer.parseInt(cus);
		NewFuelAmount= getFuelAmount()+fuelAmount;

		reader.close();
		if (NewFuelAmount < Capacity){

			BufferedWriter writer= new BufferedWriter(new FileWriter("src\\Resource\\dieselAmount.txt"));
			writer.write(String.valueOf((int)NewFuelAmount));
			writer.close();

		}else {
			System.out.println("Capacity Outbound!");
		}

	}

	public double getFuelAmount() throws IOException {
		BufferedReader reader= new BufferedReader(new FileReader("src\\Resource\\dieselAmount.txt"));
		String cus=reader.readLine();
		this.fuelAmount=Integer.parseInt(cus);
		//read current fuel amount text file
		return this.fuelAmount;
	}

}