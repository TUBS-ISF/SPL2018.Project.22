package base;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.util.ArrayList;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainWindow {

	public JFrame frmTerminkalender;
	public JTable tAppointments;
	
	public ArrayList<Appointment> appointments = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmTerminkalender.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MainWindow window) {
		
		//--------------------- Gui initialization --------------------
		frmTerminkalender = new JFrame();
		frmTerminkalender.setTitle("Terminkalender");
		frmTerminkalender.setResizable(false);
		frmTerminkalender.setBounds(100, 100, 450, 300);
		frmTerminkalender.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTerminkalender.getContentPane().setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][]", "[grow][grow][][][][][][][]"));

		tAppointments = new JTable();
		tAppointments.setModel(new DefaultTableModel(
			new Object[][] {
			}, 
			new Appointment().getAttributeNames().toArray()
		));
		frmTerminkalender.getContentPane().add(tAppointments, "cell 0 0 14 8,grow");
	}
	
	public void updateTable() {
		
		DefaultTableModel model = (DefaultTableModel) tAppointments.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			
			model.removeRow(i);
		}
		
		for(Appointment appointment : appointments) {
			
			model.addRow(appointment.getData().toArray());
		}
	}
}
