package FuelManagementSystem;

import java.util.ArrayList;

public class CommonWaitingQueue {

	private ArrayList<Customer> customers=new ArrayList<Customer>();

	CommonWaitingQueue() {
		super();
	}


	public void wait(Customer Element) {
		customers.add(Element);
		System.out.println(Element.getCustomerName()+" added to common  waiting");
	}

	public Customer parsing() {
		System.out.println(customers.get(0).getCustomerName()+" Removing from common waiting");
		customers.remove(0);

		return customers.get(0);

	}



}
