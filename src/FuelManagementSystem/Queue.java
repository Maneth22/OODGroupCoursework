package FuelManagementSystem;

import java.lang.reflect.Array;
import java.sql.*;
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
    public void checkWaitingQueue() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> com_List= new ArrayList<Customer>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM `common_queue` ");

        String Name_= null;
        String fueltype= null;
        String vehicle=null;

        while (rs.next()){
            Name_=rs.getString("customer_Name");
            vehicle=rs.getString("vehicle_Type");
            fueltype=rs.getString("fuelType");
            Customer cus= new Customer(fueltype,0,false,vehicle,Name_,null);
            com_List.add(cus);
        }
        for (int i=0;i<=com_List.size();i++){
            if (!com_List.isEmpty() && !isQueueFull() && capacity!=rear){
                TempCustomer=com_List.get(0);
                com_List.remove(0);
                TempCustomer.setTicketNo(String.valueOf(ticket.getTicketNo()));
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

                    Element.setTicketNo(String.valueOf(ticket.getTicketNo()));
                    int intTicket= Integer.parseInt(Element.getTicketNo());
                    db.enterTicket(Element.getCustomerName(),intTicket);
                    customers[rear] = Element;
                    rear++;
                    System.out.println(customers[rear-1].getCustomerName()+Element.getTicketNo());
                    db.addCustomerToQueue(Element);
                }else {
                    checkWaitingQueue();
                }
        }


        return;
	}


	public void Dequeue(String queueType) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fuelmanager", "user", "123");
        Statement stmt = con.createStatement();
        Payment payment= new Payment();
        double cost=0;

        ResultSet rs = stmt.executeQuery("SELECT * FROM `"+queueType+"` ");

        Customer Element = null;
        while (rs.next()) {

            String name = rs.getString("customer_Name");
            String Type = rs.getString("fuel_Amount");

            ResultSet rs2= stmt.executeQuery("SELECT * FROM `customer` WHERE  customer_Name='"+name+"'");
            String ticketNo=null;
            String fuelType=null;
            double fuel_Input=0;
            String cus_Vehicle=null;
            String cus_name=null;

            while (rs2.next()){
                cus_name=rs2.getString("customer_Name");
                cus_Vehicle=rs2.getString("vehicle_Type");
                fuel_Input=rs2.getInt("fuel_Amount");
                fuelType=rs2.getString("fuel_Type");
                ticketNo=String.valueOf(rs2.getInt("ticket_No"));


            }
            Customer cus=new Customer(fuelType,fuel_Input,true,cus_Vehicle,cus_name,ticketNo);
            Element=cus;

            if (capacity ==rear){
                System.out.println("Line is full!");
                return;
            }
            else{

                customers[rear] = Element;
                rear++;
                System.out.println(customers[rear-1].getCustomerName());

            }

            if (front == rear) {
                System.out.println("Line is empty");
                return;
            } else {
                for (int i = front; i < rear-1 ; i++) {
                    customers[i] = customers[i + 1];
                }
                //Remove from queue
                if (rear-1 < capacity) {
                    //customers[rear] = null;
                    rear--;
                }
                db.RemoveVehicleFromQueueDB(customers[front],queueType);
                System.out.println(customers[front].getCustomerName());
                if (!commonWait.chcklist()){
                    checkWaitingQueue();
                }

                cost=payment.setCost(customers[front]);
                System.out.println(customers[front].getFuelInput());
                stmt.executeUpdate("UPDATE `customer`"+ "SET payment='"+cost+"'"+"WHERE customer_Name='"+customers[front].getCustomerName()+"'");
                return;

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