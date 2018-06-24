import java.util.ArrayList; public   class  Appointment {
	

	 private ArrayList<String>  getData__wrappee__Base  () {
		
		return new ArrayList<String>();
	}

	
	
	 private ArrayList<String>  getData__wrappee__Title  () {
		
		ArrayList<String> data = getData__wrappee__Base();
		
		data.add(title);
		
		return data;
	}

	
	
	 private ArrayList<String>  getData__wrappee__Time  () {
		
		ArrayList<String> data = getData__wrappee__Title();
		
		data.add(time);
		
		return data;
	}

	
	
	public ArrayList<String> getData() {
		
		ArrayList<String> data = getData__wrappee__Time();
		
		data.add(priority.toString());
		
		return data;
	}

	

	private String title = "";

	

	public void setTitle(String title) {
		
		this.title = title;
	}

	
	
	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}

	

	private String time = "";

	
	
	public void setTime(String time) {
		
		this.time = time;
	}

	

	public String getTime() {
		// TODO Auto-generated method stub
		return time;
	}

	
	
	private Priority priority = Priority.none;

	
	
	public Priority getPriority() {
		
		return priority;
	}

	
	
	public void setPriority(Priority priority) {
		
		this.priority = priority;
	}


}
