package FuelManagementSystem;

import java.util.ArrayList;

public class CommonWaitingQueue extends Queue {

	private Customer customers[]=new Customer[4];


	public void Enqueue(String Element) {

	}

	public void Dequeue() {

	}

	public CommonWaitingQueue(Customer customers[]) {
		super(customers);

		this.customers=customers;
	}

}
