package FuelManagementSystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DateTime {

	private String DateTime;

	private ArrayList<String> DateDiesel;
	private ArrayList<String> DateOctane;

	public String getDate() {
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		this.DateTime=date.toString()+" : "+time.toString();
		return DateTime;
	}

	private String[] fuelAmount= new String[2];

	public ArrayList<String> getDateDiesel() {
		return DateDiesel;
	}


	public void setDateDiesel(ArrayList<String> DateDiesel) {

	}

	public ArrayList<String> getDateOctane() {
		return DateOctane;
	}

	public void setDateOctane(ArrayList<String> DateOctane) {

	}
	public void setFuelAmount(String date,String fuel){

	}
}