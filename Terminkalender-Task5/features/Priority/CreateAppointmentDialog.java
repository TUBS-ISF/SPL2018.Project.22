import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SpringLayout;

import com.sun.xml.internal.ws.api.Component;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class CreateAppointmentDialog extends JDialog implements ActionListener {

	private JComboBox<String> cbPriority;
	
	private Appointment appointment = new Appointment();
	
	private JComponent lastAddedComponent = null;
	
	public void createAppointment() {

		original();
		
		appointment.setPriority(Priority.valueOf(cbPriority.getSelectedItem().toString()));
	}

	/**
	 * Create the dialog.
	 */
	public void initialize() {
		
		original();
		
		JLabel lblPriority = new JLabel("Priorit\u00E4t:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPriority, 10, SpringLayout.SOUTH, lastAddedComponent == null ? getContentPane() : lastAddedComponent);
		springLayout.putConstraint(SpringLayout.WEST, lblPriority, 10, SpringLayout.WEST, lastAddedComponent == null ? getContentPane() : lastAddedComponent);
		getContentPane().add(lblPriority);
			
		cbPriority = new JComboBox<String>();
		springLayout.putConstraint(SpringLayout.NORTH, cbPriority, -3, SpringLayout.EAST, lblPriority);
		springLayout.putConstraint(SpringLayout.WEST, cbPriority, 6, SpringLayout.EAST, lblPriority);
		springLayout.putConstraint(SpringLayout.EAST, cbPriority, -10, SpringLayout.NORTH, getContentPane());
		getContentPane().add(cbPriority);

		for(Priority priority : Priority.values()) {
			
			cbPriority.addItem(priority.toString());
		}
		
		lastAddedComponent = lblPriority;
	}
	
	public void initialize(Appointment appointment) {

		original();

		cbPriority.setSelectedItem(appointment.getPriority().toString());
	}
}
