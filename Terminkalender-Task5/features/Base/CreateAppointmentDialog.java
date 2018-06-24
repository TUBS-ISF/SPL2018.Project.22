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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Appointment appointment = new Appointment();
	private SpringLayout springLayout = new SpringLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateAppointmentDialog dialog = new CreateAppointmentDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
		createAppointment();
		
		dispose();
	}

	private void createAppointment() {
		
	}
	
	/**
	 * Create the dialog.
	 */
	public CreateAppointmentDialog() {
		
		initialize();
	}
	
	public void initialize() {
		
		setResizable(false);
		
		setType(Type.POPUP);
		setBounds(100, 100, 212, 172);
		getContentPane().setLayout(springLayout);
		
		JButton bCancel = new JButton("Abbrechen");
		springLayout.putConstraint(SpringLayout.SOUTH, bCancel, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, bCancel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(bCancel);
		
		bCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
			}
		});
		
		JButton bOk = new JButton("OK");
		springLayout.putConstraint(SpringLayout.NORTH, bOk, 0, SpringLayout.NORTH, bCancel);
		springLayout.putConstraint(SpringLayout.EAST, bOk, -6, SpringLayout.WEST, bCancel);
		getContentPane().add(bOk);
		
		bOk.addActionListener(this);
		
		this.appointment = new Appointment();
		this.setTitle("Neuen Termin anlegen");
	}
	
	public void initialize(Appointment appointment) {
		
		this.appointment = appointment;
	}
	
	public CreateAppointmentDialog(Appointment appointment) {

		this();
		
		initialize(appointment);
	}

	public Appointment getCreatedAppointment() {

		return appointment;
	}
}
