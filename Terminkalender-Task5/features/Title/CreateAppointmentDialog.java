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

	private JTextField tfTitle;

	private Appointment appointment = new Appointment();
	
	private JComponent lastAddedComponent  = null;

	public void createAppointment() {

		original();
		
		appointment.setTitle(tfTitle.getText());
	}

	/**
	 * Create the dialog.
	 */
	public void initialize() {
		
		original();
		
		JLabel lblTitle = new JLabel("Titel:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitle, 10, SpringLayout.NORTH, lastAddedComponent == null ? getContentPane() : lastAddedComponent);
		springLayout.putConstraint(SpringLayout.WEST, lblTitle, 10, SpringLayout.WEST, lastAddedComponent == null ? getContentPane() : lastAddedComponent);
		getContentPane().add(lblTitle);
		
		tfTitle = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tfTitle, -3, SpringLayout.EAST, lblTitle);
		springLayout.putConstraint(SpringLayout.WEST, tfTitle, 6, SpringLayout.NORTH, lblTitle);
		springLayout.putConstraint(SpringLayout.EAST, tfTitle, -10, SpringLayout.EAST, getContentPane());
		tfTitle.setColumns(10);
		getContentPane().add(tfTitle);
		
		lastAddedComponent = lblTitle;
	}
	
	public void  initialize(Appointment appointment) {

		original();
		
		this.setTitle("\"" + appointment.getTitle() + "\" bearbeiten" );
		tfTitle.setText(appointment.getTitle());
	}
}
