
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import base.CreateAppointmentDialog;
import base.Appointment;

public aspect Time {

	private JTextField CreateAppointmentDialog.tfTime;
	
	private String Appointment.time = "";
	
	public String Appointment.getTime() {
		
		return time;
	}
	
	public void Appointment.setTime(String t) {
		
		time = t;
	}

	public String CreateAppointmentDialog.getTime() {
		
		return tfTime.getText();
	}
	
	public void CreateAppointmentDialog.setTime(String time) {
		
		tfTime.setText(time);
	}
	
	public void CreateAppointmentDialog.addTimeInput() {
		
		JLabel lblTime = new JLabel("Zeitpunkt:");
		getContentPane().add(lblTime, "cell 1 2,alignx left, aligny top");
	
		tfTime = new JTextField();
		tfTime.setColumns(10);
		getContentPane().add(tfTime, "cell 2 2 6 1,growx");
	}
	
	ArrayList<String> around(): execution(ArrayList<String> Appointment.getAttributeNames()) {
		
		ArrayList<String> attributes = proceed();
		
		attributes.add("Time");
		
		return attributes;
	}
	
	Appointment around(CreateAppointmentDialog c): execution(Appointment CreateAppointmentDialog.getCreatedAppointment()) && this(c) {
		
		Appointment a = proceed(c);
		
		a.setTime(c.getTime());
		
		return a;
	}
	
	List<String> around(Appointment a): execution(List<String> Appointment.getData()) && this(a){
		
		List<String> data = proceed(a);
		
		data.add(a.getTime());
		
		return data;
	}
	
	after(CreateAppointmentDialog window) : execution(void CreateAppointmentDialog.initialize(..)) && args(window) {
		
		window.addTimeInput();
	}
	
	after(CreateAppointmentDialog window, Appointment a) : execution(void CreateAppointmentDialog.initialize(CreateAppointmentDialog, Appointment)) && args(window, a) {
		
		window.setTime(a.getTime());
	}
}
