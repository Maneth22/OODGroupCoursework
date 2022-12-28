package FuelManagementSystem;

import java.util.ArrayList;

public class CommonWaitingQueue extends Queue {

	private ArrayList<Customer> customers=new ArrayList<Customer>();

	CommonWaitingQueue() {
		super();
	}


	public void wait(Customer Element) {
		customers.add(Element);
	}

	public void Dequeue() {

	}



}
