

import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTextField;
import base.Appointment;
import base.CreateAppointmentDialog;

public aspect Title {

	private JTextField CreateAppointmentDialog.tfTitle;
	
	private String Appointment.title = "";
	
	public String Appointment.getTitle() {
		
		return title;
	}
	
	public void Appointment.setTitle(String t) {
		
		title = t;
	}

	public String CreateAppointmentDialog.getTitle() {
		
		return tfTitle.getText();
	}
	
	public void CreateAppointmentDialog.setTitl(String title) {
		
		tfTitle.setText(title);
	}
	
	public void CreateAppointmentDialog.addTitleInput() {
		
		JLabel lblTitle = new JLabel("Titel:");
		getContentPane().add(lblTitle, "cell 1 1,alignx left, aligny top");
		
		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		getContentPane().add(tfTitle, "cell 2 1 6 1,growx");
	}
	
	Appointment around(CreateAppointmentDialog c): execution(Appointment CreateAppointmentDialog.getCreatedAppointment()) && this(c) {
		
		Appointment a = proceed(c);
		
		a.setTitle(c.getTitle());
		
		return a;
	}
	
	ArrayList<String> around(): execution(ArrayList<String> Appointment.getAttributeNames()) {
		
		ArrayList<String> attributes = proceed();
		
		attributes.add("Title");
		
		return attributes;
	}
	
	List<String> around(Appointment a): execution(List<String> Appointment.getData()) && target(a) {
		
		List<String> data = proceed(a);
		
		data.add(a.getTitle());
		
		return data;
	}
	
	after(CreateAppointmentDialog window) : execution(void CreateAppointmentDialog.initialize(..)) && args(window) {
		
		window.addTitleInput();
	}
	
	after(CreateAppointmentDialog window, Appointment a) : execution(void CreateAppointmentDialog.initialize(CreateAppointmentDialog, Appointment)) && args(window, a) {
		
		window.setTitl(a.getTitle());
		window.setTitle(a.getTitle() + " bearbeiten.");
	}
}
