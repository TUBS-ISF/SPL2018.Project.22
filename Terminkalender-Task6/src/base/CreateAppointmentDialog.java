package base;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;

public class CreateAppointmentDialog extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Appointment appointment = new Appointment();
	public JComponent lastAddedComponent = null;
	
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

		dispose();
	}

	/**
	 * Create the dialog.
	 */
	public CreateAppointmentDialog() {
		
		initialize(this);
	}
	
	public CreateAppointmentDialog(Appointment appointment) {

		initialize(this, appointment);
	}

	public void initialize(CreateAppointmentDialog a) {
		
		setResizable(false);
		
		setType(Type.POPUP);
		setBounds(100, 100, 212, 154);
		getContentPane().setLayout(new MigLayout("", "[47px][85px,grow][][][][][][][]", "[23px][][][][]"));
		
		JButton bOk = new JButton("OK");
		getContentPane().add(bOk, "cell 7 4,alignx left,aligny top");
		
		bOk.addActionListener(this);
		
		JButton bCancel = new JButton("Abbrechen");
		getContentPane().add(bCancel, "cell 8 4,alignx left,aligny top");
		
		bCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

		this.appointment = new Appointment();
		this.setTitle("Neuen Termin anlegen");
	}
	
	public void initialize(CreateAppointmentDialog a, Appointment appointment) {
		
		initialize(a);
		
		this.appointment = appointment;
	}
	
	public Appointment getCreatedAppointment() {

		return appointment;
	}
}
