public class Appointment {
	
	private Priority priority = Priority.none;
	
	public Priority getPriority() {
		
		return priority;
	}
	
	public void setPriority(Priority priority) {
		
		this.priority = priority;
	}
	
	public ArrayList<String> getData() {
		
		ArrayList<String> data = original();
		
		data.add(priority.toString());
		
		return data;
	}
}
