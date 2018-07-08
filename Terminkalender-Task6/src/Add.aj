

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;

import base.CreateAppointmentDialog;
import base.MainWindow;

public aspect Add {

	after(MainWindow window) : execution(void MainWindow.initialize(MainWindow)) && args(window) {
		
		JButton btnAdd = new JButton("Add");
		window.frmTerminkalender.getContentPane().add(btnAdd, "cell 11 8");
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				CreateAppointmentDialog dialog = new CreateAppointmentDialog();
				dialog.setVisible(true);
				
				dialog.addWindowListener(new WindowListener() {
					
					@Override
					public void windowClosed(WindowEvent e) {
						
						window.appointments.add(dialog.getCreatedAppointment());
						window.updateTable();
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
