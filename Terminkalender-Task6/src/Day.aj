import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

import base.Appointment;
import base.MainWindow;

public aspect Day {

	public void MainWindow.selectDayOverview() {

		DefaultTableModel model = (DefaultTableModel) tAppointments.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			
			model.removeRow(i);
		}
		
		int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_YEAR);
		
		for(Appointment appointment : appointments) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(Date.valueOf(appointment.getTime()));
			
			if(cal.get(Calendar.DAY_OF_YEAR) == currentDay) {
				model.addRow(appointment.getData().toArray());
			}	
		}
	}
	
	after(MainWindow window) : execution(void MainWindow.initialize(MainWindow)) && args(window) {
		
		JRadioButton rbtnDay = new JRadioButton("Tag");
		
		rbtnDay.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	window.selectDayOverview();
	        }
	    });
		
		window.frmTerminkalender.getContentPane().add(rbtnDay, "cell 1 8");
	}
}
