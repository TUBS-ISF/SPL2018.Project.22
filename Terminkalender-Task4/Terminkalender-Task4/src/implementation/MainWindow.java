package implementation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.util.ArrayList;
import java.util.List;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import interfaces.IAppointmentProperty;
import interfaces.IGuiControl;
import loader.PluginLoader;

public class MainWindow {

	public JFrame frmTerminkalender;
	public JTable tAppointments;
	public ArrayList<Appointment> appointments = new ArrayList<>();
	
	private List<IAppointmentProperty> propertyPlugins = PluginLoader.load(IAppointmentProperty.class);
	private List<IGuiControl> controlPlugins = PluginLoader.load(IGuiControl.class);

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frmTerminkalender = new JFrame();
		frmTerminkalender.setTitle("Terminkalender");
		frmTerminkalender.setResizable(false);
		frmTerminkalender.setBounds(100, 100, 450, 300);
		frmTerminkalender.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTerminkalender.getContentPane().setLayout(new MigLayout("", "[grow][][][][][][][][][][][][][]", "[grow][grow][][][][][][][]"));
		
		tAppointments = new JTable();
				
		String[] properties = new String[propertyPlugins.size()];

		for(int i = 0; i < propertyPlugins.size(); i++) {
			
			properties[i] = propertyPlugins.get(i).getName();
		}
		
		tAppointments.setModel(new DefaultTableModel( new Object[][] {}, properties));
		
		frmTerminkalender.getContentPane().add(tAppointments, "cell 0 0 14 8,grow");
			
		int cell = 11;
		
		for(IGuiControl control : controlPlugins) {
			
			frmTerminkalender.getContentPane().add(control.create(this), "cell " + (cell++) + " 8");
		}
	}
	
	public void updateTable() {
		
		DefaultTableModel model = (DefaultTableModel) tAppointments.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			
			model.removeRow(i);
		}

		for(Appointment appointment : appointments) {
			
			String[] properties = new String[appointment.properties.size()];
			
			for(int i = 0; i < appointment.properties.size(); i++) {
				
				properties[i] = appointment.properties.get(i).getValue();
			}
			
			model.addRow(properties);
		}
	}
}
