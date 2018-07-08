
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

import base.Appointment;
import base.MainWindow;

public aspect Week {

	public void MainWindow.selectWeekOverview() {

		DefaultTableModel model = (DefaultTableModel) tAppointments.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			
			model.removeRow(i);
		}
		
		int currentWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
		
		for(Appointment appointment : appointments) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(Date.valueOf(appointment.getTime()));
			
			if(cal.get(Calendar.WEEK_OF_YEAR) == currentWeek) {
				model.addRow(appointment.getData().toArray());
			}	
		}
	}
	
	after(MainWindow window) : execution(void MainWindow.initialize(MainWindow)) && args(window) {
		
		JRadioButton rbtnWeek = new JRadioButton("Woche");
		
		rbtnWeek.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	window.selectWeekOverview();
	        }
	    });
		
		window.frmTerminkalender.getContentPane().add(rbtnWeek, "cell 2 8");
	}
}
