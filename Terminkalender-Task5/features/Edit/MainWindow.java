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

		JButton btnEdit = new JButton("Edit");
		frmTerminkalender.getContentPane().add(btnEdit, "cell 12 8");
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedIndex = tAppointments.getSelectedRow();
				
				if(selectedIndex < appointments.size() && selectedIndex > -1) {
				
					Appointment appointment = appointments.get(selectedIndex);
					
					CreateAppointmentDialog dialog = new CreateAppointmentDialog(appointment);
					dialog.setVisible(true);
					
					dialog.addWindowListener(new WindowListener() {
						
						@Override
						public void windowClosed(WindowEvent e) {
				
							updateTable();
						}

						@Override
						public void windowActivated(WindowEvent arg0) {

						}

						@Override
						public void windowClosing(WindowEvent arg0) {

						}

						@Override
						public void windowDeactivated(WindowEvent arg0) {

						}

						@Override
						public void windowDeiconified(WindowEvent arg0) {

						}

						@Override
						public void windowIconified(WindowEvent arg0) {

						}

						@Override
						public void windowOpened(WindowEvent arg0) {

						}
					});
				}
			}
		});
	}
}