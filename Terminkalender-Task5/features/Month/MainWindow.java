import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainWindow {

	private JFrame frmTerminkalender;
	private JTable tAppointments;
	
	private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
	
	private void initialize() {
		
		original();

		JRadioButton rbtnMonth = new JRadioButton("Monat");
		
		rbtnMonth.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	selectMonthOverview();
	        }
	    });
		
		frmTerminkalender.getContentPane().add(rbtnMonth, "cell 3 8,aligny top");
	}
	
	private void selectMonthOverview() {
		
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
}