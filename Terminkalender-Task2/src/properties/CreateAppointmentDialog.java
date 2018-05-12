package properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SpringLayout;

public class CreateAppointmentDialog extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfTitle;
	private JTextField tfTime;

	private Appointment appointment = new Appointment();
	
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
		
		appointment.setTime(tfTime.getText());
		appointment.setTitle(tfTitle.getText());
		
		if((appointment.getTime() != "") && (appointment.getTitle() != "")) {
			
			dispose();
		} 
	}

	/**
	 * Create the dialog.
	 */
	public CreateAppointmentDialog() {
		setResizable(false);
		
		setType(Type.POPUP);
		setBounds(100, 100, 212, 154);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JButton bCancel = new JButton("Abbrechen");
		springLayout.putConstraint(SpringLayout.SOUTH, bCancel, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, bCancel, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(bCancel);
		
		bCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		JButton bOk = new JButton("OK");
		springLayout.putConstraint(SpringLayout.NORTH, bOk, 0, SpringLayout.NORTH, bCancel);
		springLayout.putConstraint(SpringLayout.EAST, bOk, -6, SpringLayout.WEST, bCancel);
		getContentPane().add(bOk);
		
		bOk.addActionListener(this);
		
		tfTitle = new JTextField();
		getContentPane().add(tfTitle);
		tfTitle.setColumns(10);
		
		JTextPane txtpnTitel = new JTextPane();
		txtpnTitel.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, txtpnTitel, 10, SpringLayout.NORTH, getContentPane());
		txtpnTitel.setBackground(SystemColor.control);
		txtpnTitel.setText("Titel:");
		springLayout.putConstraint(SpringLayout.WEST, txtpnTitel, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(txtpnTitel);
		
		JTextPane txtpnZeitpunkt = new JTextPane();
		txtpnZeitpunkt.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, txtpnZeitpunkt, 6, SpringLayout.SOUTH, txtpnTitel);
		springLayout.putConstraint(SpringLayout.WEST, txtpnZeitpunkt, 0, SpringLayout.WEST, txtpnTitel);
		txtpnZeitpunkt.setText("Zeitpunkt:");
		txtpnZeitpunkt.setBackground(SystemColor.menu);
		getContentPane().add(txtpnZeitpunkt);
		
		tfTime = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, tfTitle, 0, SpringLayout.WEST, tfTime);
		springLayout.putConstraint(SpringLayout.SOUTH, tfTitle, -6, SpringLayout.NORTH, tfTime);
		springLayout.putConstraint(SpringLayout.EAST, tfTitle, 0, SpringLayout.EAST, tfTime);
		springLayout.putConstraint(SpringLayout.NORTH, tfTime, 36, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, tfTime, 6, SpringLayout.EAST, txtpnZeitpunkt);
		springLayout.putConstraint(SpringLayout.EAST, tfTime, 120, SpringLayout.EAST, txtpnZeitpunkt);
		tfTime.setColumns(10);
		getContentPane().add(tfTime);
		
		this.appointment = new Appointment();
		this.setTitle("Neuen Termin anlegen");
	}
	
	public CreateAppointmentDialog(Appointment appointment) {

		this();
		
		this.appointment = appointment;
		this.setTitle("\"" + appointment.getTitle() + "\" bearbeiten" );
		
		tfTime.setText(appointment.getTime());
		tfTitle.setText(appointment.getTitle());
	}

	public Appointment getCreatedAppointment() {

		return appointment;
	}
}
