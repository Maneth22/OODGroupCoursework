package FuelManagementSystem;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class Queue {

	private int Capacity;
    private Customer TempCustomer;
	private Customer customers[];
	private boolean queueFull;
    private  int front,rear;
    private final int capacity=10;

    CommonWaitingQueue commonWait= new CommonWaitingQueue();
    DBConnector db= new DBConnector();
    //d
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

	public void Enqueue(Customer Element) throws SQLException, ClassNotFoundException {
        //checkWaitingQueue();
        String cus_fuel= Element.getFuelType();
        String cus_vehicle= Element.getVehicleType();
        int cus_count=db.getQueueCountFromDB(cus_vehicle,cus_fuel);
        this.rear=cus_count;

            if (capacity ==rear){
                System.out.println("Line is full!");
                commonWait.wait(Element );
                return;
            }
            else{
                if (commonWait.chcklist()){

                    Element.setTicketNo("T-"+String.valueOf(ticket.getTicketNo()));
                    db.enterTicket(Element.getCustomerName(),Integer.parseInt(Element.getTicketNo()));
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