public class Appointment {

	private String time = "";
	
	public void setTime(String time) {
		
		this.time = time;
	}

	public String getTime() {
		// TODO Auto-generated method stub
		return time;
	}
	
	public ArrayList<String> getData() {
		
		ArrayList<String> data = original();
		
		data.add(time);
		
		return data;
	}
}
