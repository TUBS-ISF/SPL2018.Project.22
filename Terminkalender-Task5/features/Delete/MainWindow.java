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
	
	private void initialize() {
		
		original();
		
		JButton btnDelete = new JButton("Delete");
		frmTerminkalender.getContentPane().add(btnDelete, "cell 13 8");
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = tAppointments.getSelectedRow();
				
				if(selectedIndex < appointments.size() && selectedIndex > -1) {
					
					appointments.remove(selectedIndex);
					updateTable();
				}
			}
		});
	}
}