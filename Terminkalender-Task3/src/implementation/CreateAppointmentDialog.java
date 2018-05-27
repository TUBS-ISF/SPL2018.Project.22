package implementation;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SpringLayout;

import com.sun.xml.internal.ws.api.Component;

import javafx.scene.layout.Priority;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class CreateAppointmentDialog extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//#ifdef Title
//@	private JTextField tfTitle;
	//#endif
	
	//#ifdef Time
//@	private JTextField tfTime;
	//#endif
	
	//#ifdef Priority
//@	private JComboBox cbPriority
	//#endif

	Component westOrientationComponent = null;
	Component northOrientationComponent = null;
	
	private Appointment appointment = new Appointment();
	private JTextField tfTime;
	private JTextField tfTitle;
	private JComboBox<String> cbPriority;
	
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
		
		//#ifdef Time
//@		appointment.setTime(tfTime.getText());
		//#endif
		
		//#ifdef Title
//@		appointment.setTitle(tfTitle.getText());
		//#endif
		
		//#ifdef Title
//@		appointment.setPriority(Priority.valueof(cbPriority.getText()));
		//#endif
		
		dispose();
	}

	/**
	 * Create the dialog.
	 */
	public CreateAppointmentDialog() {
		setResizable(false);
		
		setType(Type.POPUP);
		setBounds(100, 100, 212, 172);
		SpringLayout springLayout = new SpringLayout();
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
		
		JLabel lblTitle = new JLabel("Titel:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTitle, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblTitle, 10, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblTitle);
		
		JLabel lblTime = new JLabel("Zeitpunkt:");
		springLayout.putConstraint(SpringLayout.NORTH, lblTime, 6, SpringLayout.SOUTH, lblTitle);
		springLayout.putConstraint(SpringLayout.WEST, lblTime, 0, SpringLayout.WEST, lblTitle);
		getContentPane().add(lblTime);
		
		JLabel lblPriority = new JLabel("Priorit\u00E4t:");
		springLayout.putConstraint(SpringLayout.NORTH, lblPriority, 6, SpringLayout.SOUTH, lblTime);
		springLayout.putConstraint(SpringLayout.WEST, lblPriority, 0, SpringLayout.WEST, lblTitle);
		getContentPane().add(lblPriority);
		
		tfTime = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, tfTime, -3, SpringLayout.NORTH, lblTime);
		springLayout.putConstraint(SpringLayout.WEST, tfTime, 6, SpringLayout.EAST, lblTime);
		springLayout.putConstraint(SpringLayout.EAST, tfTime, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(tfTime);
		tfTime.setColumns(10);
		
		tfTitle = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, tfTitle, 31, SpringLayout.EAST, lblTitle);
		springLayout.putConstraint(SpringLayout.SOUTH, tfTitle, -3, SpringLayout.NORTH, tfTime);
		springLayout.putConstraint(SpringLayout.EAST, tfTitle, -10, SpringLayout.EAST, getContentPane());
		tfTitle.setColumns(10);
		getContentPane().add(tfTitle);
			
		cbPriority = new JComboBox<>();
		springLayout.putConstraint(SpringLayout.WEST, cbPriority, 13, SpringLayout.EAST, lblPriority);
		springLayout.putConstraint(SpringLayout.EAST, cbPriority, -10, SpringLayout.EAST, getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, cbPriority, 0, SpringLayout.NORTH, lblPriority);
		springLayout.putConstraint(SpringLayout.SOUTH, cbPriority, 20, SpringLayout.NORTH, lblPriority);
		getContentPane().add(cbPriority);

		for(Priority priority : Priority.values()) {
			
			cbPriority.addItem(priority.toString());
		}

		//#ifndef Title
		tfTitle.setVisible(false);
		lblTitle.setVisible(false);
		//#endif
		
		//#ifndef Time
		tfTime.setVisible(false);
		lblTime.setVisible(false);
		//#endif
		
		//#ifndef Priority
		cbPriority.setVisible(false);
		lblPriority.setVisible(false);
		//#endif
		
		this.appointment = new Appointment();
		this.setTitle("Neuen Termin anlegen");
	}
	
	public CreateAppointmentDialog(Appointment appointment) {

		this();
		
		this.appointment = appointment;
		
		//#ifdef Title
//@		this.setTitle("\"" + appointment.getTitle() + "\" bearbeiten" );
//@		tfTitle.setText(appointment.getTitle());
		//#endif
		
		//#ifdef Time
//@		tfTime.setText(appointment.getTime());
		//#endif

		//#ifdef Priority
//@		cbPriority.setSelectedItem(appointment.getPriority(.toString()));
		//#endif
	}

	public Appointment getCreatedAppointment() {

		return appointment;
	}
}
