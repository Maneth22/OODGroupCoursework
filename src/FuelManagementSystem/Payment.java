package FuelManagementSystem;

public class Payment {

	private double Cost;
	private double fuelAmount;
	private double petrolIncome;
	private double dieselIncome;
	private double TotalIncome;
	private Customer customer;
	private final double OctanePrice= 450;
	private final double DieselPrice= 430;

	public void setFuelAmount(double fuelAmount) {
		this.fuelAmount = fuelAmount;
	}

	public double getCost() {
		return Cost;
	}


	public double setCost(Customer customer, double temp) {
		if (customer.getFuelType()=="Diesel") {
			temp = DieselPrice * customer.getFuelInput();
		} else if (customer.getFuelType()=="Petrol") {
			temp =OctanePrice * customer.getFuelInput();
		}
		return temp;
	}

	public void CalculateIncome(double fuelAmount,String fuelType) {
		//calculate total income
		if (fuelType=="diesel"){
			this.dieselIncome=DieselPrice*fuelAmount;
			this.TotalIncome+=dieselIncome;
		}
	}

	public double getTotalIncome() {
		return TotalIncome;
	}

}