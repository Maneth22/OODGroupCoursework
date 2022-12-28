package FuelManagementSystem;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Queue {

	private int Capacity;
    private Customer TempCustomer;
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
        for (int i=0;i<=commonWait.size();i++){
            if (!commonWait.chcklist() && !isQueueFull() && capacity!=rear){
                TempCustomer=commonWait.parsing();
                commonWait.remove();
                TempCustomer.setTicketNo("T-"+String.valueOf(ticket.getTicketNo()));
                customers[rear] = TempCustomer;
                rear++;
                System.out.println("Added from common waiting queue "+customers[rear-1].getCustomerName()+" "+TempCustomer.getTicketNo());
            }
            else {
                System.out.println("line is full or no cmmn wait");
            }
        }

    }

	public void Enqueue(Customer Element) {
        //checkWaitingQueue();
            if (capacity ==rear){
                System.out.println("Line is full!");
                commonWait.wait(Element );
                return;
            }
            else{
                if (commonWait.chcklist()){

                    Element.setTicketNo("T-"+String.valueOf(ticket.getTicketNo()));
                    customers[rear] = Element;
                    rear++;
                    System.out.println(customers[rear-1].getCustomerName()+Element.getTicketNo());

                }else {
                    checkWaitingQueue();
                }
        }


        return;
	}

	public void Dequeue() {
		//Remove from queue
        if (front == rear) {
            System.out.println("Line is empty");
            return;
        } else {
            for (int i = front; i < rear-1 ; i++) {
                customers[i] = customers[i + 1];
            }
            if (rear-1 < capacity) {
                //customers[rear] = null;
                rear--;
            }
            System.out.println(customers[front].getCustomerName());
            if (!commonWait.chcklist()){
                checkWaitingQueue();
            }

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