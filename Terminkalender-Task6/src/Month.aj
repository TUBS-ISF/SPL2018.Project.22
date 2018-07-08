import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

import base.Appointment;
import base.MainWindow;

public aspect Month {

	public void MainWindow.selectMonthOverview() {

		DefaultTableModel model = (DefaultTableModel) tAppointments.getModel();
		
		for(int i = 0; i < model.getRowCount(); i++) {
			
			model.removeRow(i);
		}
		
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		
		for(Appointment appointment : appointments) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(Date.valueOf(appointment.getTime()));
			
			if(cal.get(Calendar.MONTH) == currentMonth) {
				model.addRow(appointment.getData().toArray());
			}	
		}
	}
	
	after(MainWindow window) : execution(void MainWindow.initialize(MainWindow)) && args(window) {
		
		JRadioButton rbtnMonth = new JRadioButton("Monat");
		
		rbtnMonth.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	window.selectMonthOverview();
	        }
	    });
		
		window.frmTerminkalender.getContentPane().add(rbtnMonth, "cell 3 8,alignx left, aligny top");
	}
}
