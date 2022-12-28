package FuelManagementSystem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Queue {

	private int Capacity;
	private Customer customers[];
	private boolean queueFull;
    private  int front,rear;
    private int capacity=10;

    CommonWaitingQueue carWait= new CommonWaitingQueue();
	Ticket ticket=new Ticket();

    Queue(){
        front = 0;
        rear = 0;
        capacity = 10;
        customers = new Customer[capacity];
    }
	public void Enqueue(Customer Element) {
		//Has to change
        if (capacity ==rear){
            System.out.println("Line is full!");

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



	public static boolean getQueueFull(Object Queue) {
		//if the queue is full return true

		return true;
	}




	public void IssueTicket() {
		//generate random ticket number
		ticket.getTicketNo();

	}

}