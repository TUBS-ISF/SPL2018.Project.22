

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JButton;
import base.Appointment;
import base.CreateAppointmentDialog;
import base.MainWindow;

public aspect Edit {

	after(MainWindow window) : execution(void MainWindow.initialize(MainWindow)) && args(window) {
		
		JButton btnEdit = new JButton("Edit");
		window.frmTerminkalender.getContentPane().add(btnEdit, "cell 12 8");
		
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				int selectedIndex = window.tAppointments.getSelectedRow();
				
				if(selectedIndex < window.appointments.size() && selectedIndex > -1) {
				
					Appointment appointment = window.appointments.get(selectedIndex);
					
					CreateAppointmentDialog dialog = new CreateAppointmentDialog(appointment);
					dialog.setVisible(true);
					
					dialog.addWindowListener(new WindowListener() {
						
						@Override
						public void windowClosed(WindowEvent e) {					
							window.updateTable();
						}
	
						@Override
						public void windowActivated(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}
	
						@Override
						public void windowClosing(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}
	
						@Override
						public void windowDeactivated(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}
	
						@Override
						public void windowDeiconified(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}
	
						@Override
						public void windowIconified(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}
	
						@Override
						public void windowOpened(WindowEvent arg0) {
							// TODO Auto-generated method stub
							
						}
					});
				}
			}
		});
	}
}
