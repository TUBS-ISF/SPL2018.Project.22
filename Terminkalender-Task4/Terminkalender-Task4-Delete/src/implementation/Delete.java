package implementation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;

import interfaces.IGuiControl;

public class Delete implements IGuiControl{

	@Override
	public JButton create(MainWindow parent) {
		
		JButton btnDelete = new JButton("Delete");

		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = parent.tAppointments.getSelectedRow();
				
				if(selectedIndex <  parent.appointments.size() && selectedIndex > -1) {
					
					 parent.appointments.remove(selectedIndex);
					 parent.updateTable();
				}
			}
		});
		
		return btnDelete;
	}
}
