package FuelManagementSystem;
import java.util.Random;
public class Ticket {

	private int TicketNo;

	public int getTicketNo() {
		setTicketNo();
		return TicketNo;
	}

	public void setTicketNo() {
		//Generate Random Ticket Numbers and save to file
		Random random = new Random();
		// Generate random integers in range 0 to 999 for ticket number
		TicketNo = random.nextInt(1000);
		// Print ticket number
		System.out.println("Ticket Number: "+"T-"+TicketNo);

	}

}