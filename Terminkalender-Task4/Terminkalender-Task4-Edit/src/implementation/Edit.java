package implementation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;

import interfaces.IGuiControl;

public class Edit implements IGuiControl {

	@Override
	public JButton create(MainWindow parent) {
		
		JButton btnEdit = new JButton("Edit");

		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedIndex = parent.tAppointments.getSelectedRow();
				
				if(selectedIndex < parent.appointments.size() && selectedIndex > -1) {
				
					Appointment appointment = parent.appointments.get(selectedIndex);
					
					CreateAppointmentDialog dialog = new CreateAppointmentDialog(appointment);
					dialog.setVisible(true);
					
					dialog.addWindowListener(new WindowListener() {
						
						@Override
						public void windowClosed(WindowEvent e) {
				
							parent.updateTable();
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
		
		return btnEdit;
	}
}
