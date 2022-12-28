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

		Customer customer1= new Customer("petrol", 9,false,"car","SANA",null);
		Customer customer2= new Customer("petrol", 9,false,"car","SANA",null);
		Customer customer3= new Customer("petrol", 9,false,"car","SANA",null);
		Customer customer4= new Customer("petrol", 9,false,"car","SANA",null);
		Customer customer5= new Customer("petrol", 9,false,"car","SANA",null);
		Customer customer6= new Customer("petrol", 9,false,"car","SANA",null);
		Customer customer7= new Customer("petrol", 9,false,"car","SANA",null);
		Customer customer8= new Customer("petrol", 9,false,"car","SANA",null);
		Customer customer9= new Customer("petrol", 9,false,"car","SANA",null);
		Customer customer10= new Customer("petrol", 9,false,"car","SANA",null);
		Customer customer11= new Customer("petrol", 9,false,"car","SANA",null);

		/*OctaneFuelDispenseManager oD= new OctaneFuelDispenseManager();
		PetrolDispenser PD1= new PetrolDispenser(1,"Car");


		System.out.println(oD.getFuelAmount());

		PD1.fillVehicle(150);
		System.out.println(oD.getFuelAmount());*/
		Queue carQ= new Queue();
		carQ.Enqueue(customer1);
		carQ.Enqueue(customer2);
		carQ.Enqueue(customer3);
		carQ.Enqueue(customer4);
		carQ.Enqueue(customer5);
		carQ.Enqueue(customer6);
		carQ.Enqueue(customer7);
		carQ.Enqueue(customer8);
		carQ.Enqueue(customer9);
		carQ.Enqueue(customer10);
		carQ.Enqueue(customer11);


	}

}