package properties;

public class Appointment {

	private String time = "";
	private String title = "";
	
	public void setTime(String time) {
		
		this.time = time;
	}
	
	public void setTitle(String title) {
		
		this.title = title;
	}
	
	@Override
	public String toString() {
		
		return "Titel: " + title + ", " + "Zeitpunkt: " + time;
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	
	public String getTime() {
		// TODO Auto-generated method stub
		return time;
	}
}
