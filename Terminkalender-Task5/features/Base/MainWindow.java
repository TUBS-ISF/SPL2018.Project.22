import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainWindow {

	private JFrame frmTerminkalender;
	private JTable tAppointments;
	
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
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
	
	private void initialize() {

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
			new String[] {
				
				"Titel",
					
				"Zeitpunkt",
					
				"Priorität"
			}
		));
		
		frmTerminkalender.getContentPane().add(tAppointments, "cell 0 0 14 8,grow");
	}
	
	private MainWindow() {
		
		initialize();
	}
	
	private void updateTable() {
		
		DefaultTableModel model = (DefaultTableModel) tAppointments.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			
			model.removeRow(i);
		}
		
		for(Appointment appointment : appointments) {
			
			model.addRow(appointment.getData().toArray());
		}
	}
}