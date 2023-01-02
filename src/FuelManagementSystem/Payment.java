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


	public double setCost(Customer customer) {

		if (customer.getFuelType().equals("diesel")) {
			this.Cost = DieselPrice * customer.getFuelInput();
		} else if (customer.getFuelType().equals("petrol")) {
			this.Cost =OctanePrice * customer.getFuelInput();

		}
		return this.Cost;
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