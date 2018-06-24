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
	
	private JTextField tfTime;

	private Appointment appointment = new Appointment();
	
	private JComponent lastAddedComponent = null;
	
	public void createAppointment() {

		original();
		
		appointment.setTime(tfTime.getText());
	}

	/**
	 * Create the dialog.
	 */
	public void initialize() {
		
		original();
		
		JLabel lblTime = new JLabel("Zeitpunkt:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTime, 10, SpringLayout.SOUTH, lastAddedComponent == null ? getContentPane() : lastAddedComponent);
		springLayout.putConstraint(SpringLayout.WEST, lblTime, 10, SpringLayout.WEST, lastAddedComponent == null ? getContentPane() : lastAddedComponent);
		getContentPane().add(lblTime);
	
		tfTime = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tfTime, -3, SpringLayout.NORTH, lblTime);
		springLayout.putConstraint(SpringLayout.WEST, tfTime, 6, SpringLayout.EAST, lblTime);
		springLayout.putConstraint(SpringLayout.EAST, tfTime, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(tfTime);
		tfTime.setColumns(10);
		
		lastAddedComponent = lblTime;
	}
	
	public void initialize(Appointment appointment) {

		original();
		
		tfTime.setText(appointment.getTime());
	}
}
