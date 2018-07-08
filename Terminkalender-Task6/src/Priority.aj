import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import base.Appointment;
import base.CreateAppointmentDialog;
import base.PriorityEnum;

public aspect Priority {

	private JComboBox<String> CreateAppointmentDialog.cbPriority;
	
	private PriorityEnum Appointment.priority = PriorityEnum.None;
	
	public PriorityEnum Appointment.getPriority() {
		
		return priority;
	}
	
	public void Appointment.setPriority(PriorityEnum p) {
		
		priority = p;
	}

	public PriorityEnum CreateAppointmentDialog.getPriority() {
		
		return PriorityEnum.valueOf(cbPriority.getSelectedItem().toString());
	}
	
	public void CreateAppointmentDialog.setPriority(PriorityEnum p) {
		
		cbPriority.setSelectedItem(p.toString());
	}
	
	public void CreateAppointmentDialog.addPriorityInput() {
		
		JLabel lblPriority = new JLabel("Priorität:");
		getContentPane().add(lblPriority, "cell 1 3,alignx left, aligny top");
	
		cbPriority = new JComboBox<String>();
		
		for(PriorityEnum priority : PriorityEnum.values()) {
			
			cbPriority.addItem(priority.toString());
		}
		
		getContentPane().add(cbPriority, "cell 2 3 6 1,growx");
	}
	
	ArrayList<String> around(): execution(ArrayList<String> Appointment.getAttributeNames()) {
		
		ArrayList<String> attributes = proceed();
		
		attributes.add("Priorität");
		
		return attributes;
	}
	
	Appointment around(CreateAppointmentDialog c): execution(Appointment CreateAppointmentDialog.getCreatedAppointment()) && this(c) {
		
		Appointment a = proceed(c);
		
		a.setPriority(c.getPriority());
		
		return a;
	}
	
	List<String> around(Appointment a): execution(List<String> Appointment.getData()) && this(a){
		
		List<String> data = proceed(a);
		
		data.add(a.getPriority().toString());
		
		return data;
	}
	
	after(CreateAppointmentDialog window) : execution(void CreateAppointmentDialog.initialize(..)) && args(window) {
		
		window.addPriorityInput();
	}
	
	after(CreateAppointmentDialog window, Appointment a) : execution(void CreateAppointmentDialog.initialize(CreateAppointmentDialog, Appointment)) && args(window, a) {
		
		window.setPriority(a.getPriority());
	}
}
