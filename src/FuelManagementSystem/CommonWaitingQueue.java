package FuelManagementSystem;

import java.util.ArrayList;

public class CommonWaitingQueue {

	private ArrayList<Customer> customers=new ArrayList<Customer>();

	CommonWaitingQueue() {
		super();
	}


	public void wait(Customer Element) {
		this.customers.add(Element);
		System.out.println(Element.getCustomerName()+" added to common  waiting");
	}
	public boolean chcklist(){
		return customers.isEmpty();
	}
	public int size(){
		return customers.size();
	}

	public Customer parsing() {
		System.out.println(customers.get(0).getCustomerName()+" Removing from common waiting");
		this.customers.remove(0);

		return customers.get(0);

	}



}
