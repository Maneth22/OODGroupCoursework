package FuelManagementSystem;

public class Payment {

	private double Cost;
	private double fuelAmount;
	private double petrolIncome;
	private double dieselIncome;
	private double TotalIncome;
	private final double OctanePrice= 450;
	private final double DieselPrice= 430;

	public void setFuelAmount(double fuelAmount) {
		this.fuelAmount = fuelAmount;
	}

	public double getCost() {
		return Cost;
	}


	public void setCost(double Cost) {
		this.Cost=Cost;
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