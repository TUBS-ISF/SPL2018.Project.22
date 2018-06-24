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
		
		JButton btnAdd = new JButton("Add");
		frmTerminkalender.getContentPane().add(btnAdd, "cell 11 8");
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CreateAppointmentDialog dialog = new CreateAppointmentDialog();
				dialog.setVisible(true);
				
				dialog.addWindowListener(new WindowListener() {
					
					@Override
					public void windowClosed(WindowEvent e) {
						
						appointments.add(dialog.getCreatedAppointment());
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
		});

	}
}