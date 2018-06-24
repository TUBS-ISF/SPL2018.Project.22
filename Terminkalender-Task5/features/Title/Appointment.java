public class Appointment {

	private String title = "";

	public void setTitle(String title) {
		
		this.title = title;
	}
	
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	
	public ArrayList<String> getData() {
		
		ArrayList<String> data = original();
		
		data.add(title);
		
		return data;
	}
}
