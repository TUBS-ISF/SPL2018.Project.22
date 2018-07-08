

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import base.MainWindow;

public aspect Delete {

	after(MainWindow window) : execution(void MainWindow.initialize(MainWindow)) && args(window) {
		
		JButton btnDelete = new JButton("Delete");
		window.frmTerminkalender.getContentPane().add(btnDelete, "cell 13 8");
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedIndex = window.tAppointments.getSelectedRow();
				
				if(selectedIndex < window.appointments.size() && selectedIndex > -1) {
					
					window.appointments.remove(selectedIndex);
					window.updateTable();
				}
			}
		});
	}
}
