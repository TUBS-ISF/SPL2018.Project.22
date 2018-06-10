package implementation;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SpringLayout;
import interfaces.IAppointmentProperty;
import loader.PluginLoader;
import javax.swing.JComponent;

public class CreateAppointmentDialog extends JDialog implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		
		for(IAppointmentProperty propertie : PluginLoader.load(IAppointmentProperty.class)) {
			
			for(JComponent component : propertie.createInputComponents()) {
				
				getContentPane().add(component);
			}	
		}
		
		this.appointment = new Appointment();
		this.setTitle("Neuen Termin anlegen");
	}
	
	public CreateAppointmentDialog(Appointment appointment) {

		this();
		
		this.appointment = appointment;
		
		
	}

	public Appointment getCreatedAppointment() {

		for(IAppointmentProperty property : appointment.properties) {
			
			property.setValue();
		}
		
		return appointment;
	}
}
