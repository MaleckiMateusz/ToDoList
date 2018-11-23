import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;

public class task {
	private String description = "";
	private int priority = 4;
	private JSpinner datespin;
	private String datetask;
	private int dayrecurrence = 0;
	
	public task(String thedescription, int thepriority, JSpinner dateE, String thedayrecurrence) {
		description = thedescription;
		priority = thepriority;
		datespin = dateE;
		dayrecurrence = Integer.parseInt(thedayrecurrence);
	}
	
	
	public String getDescription() {
		return description;	
	}
	
	public int getPriority() {
		return priority;	
	}
	
	public String getDate() {
		String day = "" + datespin.getValue();
		
		if(day.substring(20, 23).equals("CET")) 
			return day.substring(24, 28) + monthStringToInt(day.substring(4, 7)) + day.substring(8, 10); //CET
		else 
			return day.substring(25, 29) + day.substring(4, 7) + day.substring(8, 10); //CET
	}

	public int getRecurrence() {
		return dayrecurrence;
	}
	
	private String monthStringToInt(String str) {
		String month = ""; 
		switch (str){
			case "Jan":
				month = "01";
				break;
			case "Feb":
				month = "02";
				break;
			case "Mar":
				month = "03";
				break;
			case "Apr":
				month = "04";
				break;
			case "May":
				month = "05";
				break;
			case "Jun":
				month = "06";
				break;
			case "Jul":
				month = "07";
				break;
			case "Aug":
				month = "08";
				break;
			case "Sep":
				month = "09";
				break;
			case "Oct":
				month = "10";
				break;
			case "Nov":
				month = "11";
				break;
			case "Dec":
				month = "12";
				break;
			default:
				month = "00";
		}
		return month;
	}
}
