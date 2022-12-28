package FuelManagementSystem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Queue {

	private int Capacity;
	private Customer customers[];
	private boolean queueFull;
    private  int front,rear;
    private final int capacity=10;

    CommonWaitingQueue commonWait= new CommonWaitingQueue();
	Ticket ticket=new Ticket();

    Queue(){
        front = 0;
        rear = 0;
        customers = new Customer[capacity];
    }
    public void checkWaitingQueue(){
        Customer TempCustomer;
        for (int i=0;i<=commonWait.size();i++){
            if (commonWait.chcklist() && !isQueueFull()){
                TempCustomer=commonWait.parsing();
                TempCustomer.setTicketNo("T-"+String.valueOf(ticket.getTicketNo()));
                customers[rear] = TempCustomer;
                rear++;
                System.out.println(customers[rear-1].getCustomerName()+" "+TempCustomer.getTicketNo());
            }
        }
    }

	public void Enqueue(Customer Element) {
        if (capacity ==rear){
            System.out.println("Line is full!");
            commonWait.wait(Element );
            return;
        }
        else{
            Element.setTicketNo("T-"+String.valueOf(ticket.getTicketNo()));
            customers[rear] = Element;
            rear++;
            System.out.println(customers[rear-1].getCustomerName()+" "+Element.getTicketNo());
        }
        return;
	}

	public void Dequeue() {
		//Remove from queue
        if (front == rear) {
            System.out.println("Line is empty");
            return;
        } else {
            for (int i = 0; i < rear - 1; i++) {
                customers[i] = customers[i + 1];
            }
            if (rear < capacity) {
                customers[rear] = null;
                rear--;
            }
            return;
        }
	}



	public boolean isQueueFull(){
        return capacity==rear;
    }




	public void IssueTicket() {
		//generate random ticket number
		ticket.getTicketNo();

	}

}