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

public   class  CreateAppointmentDialog  extends JDialog  implements ActionListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	private Appointment appointment  = new Appointment();

	
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

	

	  private void  createAppointment__wrappee__Base  () {
		
	}

	

	 private void  createAppointment__wrappee__Title  () {

		createAppointment__wrappee__Base();
		
		appointment.setTitle(tfTitle.getText());
	}

	
	
	 private void  createAppointment__wrappee__Time  () {

		createAppointment__wrappee__Title();
		
		appointment.setTime(tfTime.getText());
	}

	
	
	public void createAppointment() {

		createAppointment__wrappee__Time();
		
		appointment.setPriority(Priority.valueOf(cbPriority.getSelectedItem().toString()));
	}

	
	
	/**
	 * Create the dialog.
	 */
	public CreateAppointmentDialog() {
		
		initialize();
	}

	
	
	 private void  initialize__wrappee__Base() {
		
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

	

	/**
	 * Create the dialog.
	 */
	 private void  initialize__wrappee__Title  () {
		
		initialize__wrappee__Base();
		
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

	

	/**
	 * Create the dialog.
	 */
	 private void  initialize__wrappee__Time  () {
		
		initialize__wrappee__Title();
		
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

	

	/**
	 * Create the dialog.
	 */
	public void initialize() {
		
		initialize__wrappee__Time();
		
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

	
	
	 private void  initialize__wrappee__Base  (Appointment appointment) {
		
		this.appointment = appointment;
	}

	
	
	 private void  initialize__wrappee__Title  (Appointment appointment) {

		initialize__wrappee__Base();
		
		this.setTitle("\"" + appointment.getTitle() + "\" bearbeiten" );
		tfTitle.setText(appointment.getTitle());
	}

	
	
	 private void  initialize__wrappee__Time  (Appointment appointment) {

		initialize__wrappee__Title();
		
		tfTime.setText(appointment.getTime());
	}

	
	
	public void initialize(Appointment appointment) {

		initialize__wrappee__Time();

		cbPriority.setSelectedItem(appointment.getPriority().toString());
	}

	
	
	public CreateAppointmentDialog(Appointment appointment) {

		this();
		
		initialize(appointment);
	}

	

	public Appointment getCreatedAppointment() {

		return appointment;
	}

	

	private JTextField tfTitle;

	
	
	private JComponent lastAddedComponent  = null;

	
	
	private JTextField tfTime;

	

	private JComboBox<String> cbPriority;


}
