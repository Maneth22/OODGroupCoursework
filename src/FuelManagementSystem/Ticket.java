package FuelManagementSystem;
import java.util.Random;
public class Ticket {

	private int TicketNo;

	public int getTicketNo() {
		return TicketNo;
	}

	public void setTicketNo(int TicketNo) {
		//Generate Random Ticket Numbers and save to file
		Random random = new Random();
		// Generate random integers in range 0 to 999 for ticket number
		TicketNo = random.nextInt(1000);
		this.TicketNo=TicketNo;
		// Print ticket number
		System.out.println("Ticket Number: "+"T-"+TicketNo);

	}

}