package FuelManagementSystem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Queue {

	private int Capacity;
	private Customer customers[]=new Customer[10];//Has to change
	private boolean queueFull;
    private  int front,rear;
    private int capacity=10;


	Ticket ticket=new Ticket();

    Queue(int size){
        front = 0;
        rear = 0;
        capacity = size;
        customers = new Customer[capacity];
    }
	public void Enqueue(Customer Element) {
		//Has to change
        if (capacity ==rear){
            System.out.println("Line is full!");
            return;
        }
        else{
            customers[rear] = Element;
            rear++;
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